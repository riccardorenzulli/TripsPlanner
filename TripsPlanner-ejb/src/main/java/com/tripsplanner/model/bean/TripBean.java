/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.model.bean;

import com.tripsplanner.model.entity.DayItinerary;
import com.tripsplanner.model.entity.Place;
import com.tripsplanner.model.entity.Route;
import com.tripsplanner.model.entity.Trip;
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

    
    
    /*Given the interesting places to be visited and the number of days
      return an arraylist for each cluster containing the indexes of the
      places belonging to the clusters.
    */
    public Trip buildTrip(List<Place> interestingPlaces, int dayTrips) {
        Trip trip = null;
        ArrayList<ArrayList<Integer>> clusters = calculateClusters(interestingPlaces, dayTrips);
        
        try {
            trip = fromClustersToTrip(interestingPlaces, clusters);
        } catch (IOException ex) {
            Logger.getLogger(TripBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return trip;
    }
    
    private ArrayList<ArrayList<Integer>> calculateClusters(List<Place> interestingPlaces, int dayTrips) {
        /*Clustering + shortest path tour*/
        Random rand = new Random();
        List<Place> places = interestingPlaces;
        int daysOfTrip = dayTrips;
        int numberOfPlaces = places.size();
        
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
        
        ArrayList<ArrayList<Integer>> clusters = null;
        
        int iterations = 5;
        for(int it=0; it<iterations; it++) {
            /*Clean the clusters*/
            clusters = clusters = new ArrayList<>();
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

    
}