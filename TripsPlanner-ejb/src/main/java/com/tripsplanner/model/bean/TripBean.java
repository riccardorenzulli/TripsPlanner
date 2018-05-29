/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.model.bean;

import com.tripsplanner.model.entity.DayItinerary;
import com.tripsplanner.model.entity.Hotel;
import com.tripsplanner.model.entity.Place;
import com.tripsplanner.model.entity.Route;
import com.tripsplanner.model.entity.Trip;
import com.tripsplanner.model.facade.TripFacadeLocal;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author the-silent-fox
 */
@Stateless
public class TripBean implements TripBeanLocal {

    @EJB
    private GoogleDirectionsBean dirBean;

    @EJB
    private TripFacadeLocal tripBean;
    
    /*Given the interesting places to be visited and the number of days
      return an arraylist for each cluster containing the indexes of the
      places belonging to the clusters.
    */
    public Trip buildTrip(List<Place> interestingPlaces, int dayTrips, Hotel hotel) {
        Trip trip = null;
        
        ArrayList<ArrayList<Integer>> clusters = null;
        int attempts = 0;
        
        while(!satisfyingClusters(clusters,interestingPlaces.size()) && attempts < 5) {
            clusters = calculateClusters(interestingPlaces, dayTrips);
            attempts++;
        }
        
        if(!satisfyingClusters(clusters,interestingPlaces.size()))
            clusters = forceModifyClusters(clusters);
        
        if(hotel != null) {
            Place hotelPlace = fromHotelToPlace(hotel);
            interestingPlaces.add(hotelPlace);
            int indexHotel = interestingPlaces.size()-1;
            for(ArrayList<Integer> cluster : clusters) {
                cluster.add(0, indexHotel);
                cluster.add(indexHotel);
            }
        }
        
        try {
            trip = fromClustersToTrip(interestingPlaces, clusters);
        } catch (IOException ex) {
            Logger.getLogger(TripBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return trip;
    }
    
    private ArrayList<ArrayList<Integer>> calculateClusters(List<Place> interestingPlaces, int dayTrips) {
        /*Clustering + shortest path tour*/

        List<Place> places = interestingPlaces;
        int daysOfTrip = dayTrips;
        int numberOfPlaces = places.size();
        
        ArrayList<Integer> medoidsIndexes = randomMedoids(daysOfTrip,numberOfPlaces);

        ArrayList<ArrayList<Integer>> clusters = null;
        
        int iterations = 2;
        for(int it=0; it<iterations; it++) {
            /*Clean the clusters*/
            clusters = new ArrayList<>();
            for(int i=0; i<daysOfTrip; i++)
                clusters.add(new ArrayList<Integer>());
            
            /*Assign places to the closest medoids*/
            for(int i=0; i<numberOfPlaces; i++) {
                int closestClusterIndex = getClosestCluster(places, medoidsIndexes, i);
                clusters.get(closestClusterIndex).add(i); //put the place i in the closest cluster
            }
            
            /*Recalculate medoids*/
            for(int i=0; i<medoidsIndexes.size(); i++) {
                int indexBestMedoid = calculateBestMedoid(places, clusters.get(i), i);
                medoidsIndexes.set(i, indexBestMedoid);
            }
        }

        for(int i=0; i<clusters.size(); i++) {
            System.out.println("Cluster_"+i+":{");
            for(int index : clusters.get(i))
                System.out.print(" "+index);
            System.out.print("}\n");
        }
        for(int i=0; i<places.size(); i++)
            System.out.println(places.get(i).getLat()+","+places.get(i).getLng()+","+i);
        
        return clusters;
    }

    private int getClosestCluster(List<Place> places, ArrayList<Integer> medoidsIndexes, int placeIndex) {
        int indexClosestCluster = 0;
        float minDistance = Float.MAX_VALUE;
        for(int i=0; i<medoidsIndexes.size(); i++) {
            float distance = getDistance(places.get(placeIndex), places.get(i));
            if(distance < minDistance) {
                minDistance = distance;
                indexClosestCluster = i;
            }
        }
        return indexClosestCluster;
    }

    /*Euclidean distance between two places*/
    private float getDistance(Place place1, Place place2) {
       float latDifference = (float) Math.pow(place1.getLat() - place2.getLat(), 2);
       float lngDifference = (float) Math.pow(place1.getLng() - place2.getLng(), 2);
       return (float) Math.sqrt(latDifference + lngDifference);
    }

    /*Given the cluster, recalculate the medoid*/
    private int calculateBestMedoid(List<Place> places, ArrayList<Integer> clusterIndexes, int i) {
        int medoidIndex = clusterIndexes.get(0);
        float minDistancesSum = Float.MIN_VALUE;
        for(int index : clusterIndexes) {
            float distancesSum = 0;
            for(int otherIndex : clusterIndexes)
                distancesSum += getDistance(places.get(index), places.get(otherIndex));
            if(distancesSum < minDistancesSum)
                medoidIndex = index;
        }
        return medoidIndex;
    }

    private Trip fromClustersToTrip(List<Place> interestingPlaces, ArrayList<ArrayList<Integer>> clusters) throws IOException {
        Trip trip = new Trip();
        ArrayList<DayItinerary> itinerary = new ArrayList();
        /*For each cluster*/
        for(int i=0; i<clusters.size(); i++) {
            DayItinerary dayItinerary = new DayItinerary();
            ArrayList<Route> legs = new ArrayList();
            /*For each element of the cluster i*/
            for(int j=0; j<clusters.get(i).size()-1; j++) {
                int indexPlace1 = clusters.get(i).get(j);
                int indexPlace2 = clusters.get(i).get(j+1);
                Place place1 = interestingPlaces.get(indexPlace1);
                Place place2 = interestingPlaces.get(indexPlace2);
                Route route = createRouteFromPlaces(place1, place2);
                legs.add(route);
            }
            dayItinerary.setLegs(legs);
            itinerary.add(dayItinerary);
        }
        trip.setItineraries(itinerary);
        return trip;
    }

    private Route createRouteFromPlaces(Place departure, Place destination) throws IOException {
        Route route = dirBean.getRoute(departure, destination, "driving", "now");

        return route;
    }

    private ArrayList<Integer> randomMedoids(int daysOfTrip, int numberOfPlaces) {
        Random rand = new Random();
        ArrayList<Integer> medoidsIndexes = new ArrayList<>();        
        /*initializing centroids*/
        for(int i=0; i<daysOfTrip; i++) {
            boolean equalCentroids = true;
            /*create unique centroids*/
            while(equalCentroids) {
                int newIndex = rand.nextInt(numberOfPlaces);
                if(!medoidsIndexes.contains(newIndex)) { //need to use Integer object?
                    medoidsIndexes.add(newIndex);
                    equalCentroids = false;
                }
            }
        }
        return medoidsIndexes;
    }

    private boolean satisfyingClusters(ArrayList<ArrayList<Integer>> clusters, int totalPlaces) {
        if(clusters == null)
            return false;
        for(int i=0; i<clusters.size(); i++) {
            if(clusters.get(i).size() < 2 || clusters.get(i).size() > (totalPlaces/3 + 1))
                return false;
        }
        return true;
    }

    private ArrayList<ArrayList<Integer>> forceModifyClusters(ArrayList<ArrayList<Integer>> clusters) {
        ArrayList<ArrayList<Integer>> newClusters = clusters;
        int indexBiggestCluster = 0;
        int biggestSize = 0;
        for(int i=0; i<newClusters.size(); i++) {
            if(newClusters.get(i).size() > biggestSize) {
                indexBiggestCluster = i;
                biggestSize = newClusters.get(i).size();
            }
        }
        
        for(int i=0; i<newClusters.size(); i++) {
            if(newClusters.get(i).size() < 2) {
                int example = newClusters.get(indexBiggestCluster).remove(0);
                newClusters.get(i).add(example);
            }
        }
        return newClusters;
    }

    @Override
    public void saveTrip(Trip myTrip) {
        tripBean.create(myTrip);
    }

    private Place fromHotelToPlace(Hotel hotel) {
        Place hotelPlace = new Place();
        hotelPlace.setName(hotel.getName());
        hotelPlace.setAddress(hotel.getAddress());
        hotelPlace.setDescription("");
        hotelPlace.setLat(hotel.getLatitude());
        hotelPlace.setLng(hotel.getLongitude());
        hotelPlace.setId(hotel.getId()); //???????
        hotelPlace.setPhotosUrl("https://cdn.pixabay.com/photo/2015/07/18/04/48/hotel-850020_960_720.jpg");
        return hotelPlace;
    }
    
    
}