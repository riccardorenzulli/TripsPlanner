package com.tripsplanner.model.bean;

import com.tripsplanner.model.entity.DayItinerary;
import com.tripsplanner.model.entity.Hotel;
import com.tripsplanner.model.entity.Place;
import com.tripsplanner.model.entity.Route;
import com.tripsplanner.model.entity.Search;
import com.tripsplanner.model.entity.Trip;
import com.tripsplanner.model.entity.User;
import com.tripsplanner.model.facade.DayItineraryFacadeLocal;
import com.tripsplanner.model.facade.PlaceFacadeLocal;
import com.tripsplanner.model.facade.RouteFacadeLocal;
import com.tripsplanner.model.facade.TripFacadeLocal;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Authors: Giovanni Bonetta, Riccardo Renzulli, Gabriele Sartor<br>
 * Università degli Studi di Torino<br>
 * Department of Computer Science<br>
 * Sviluppo Software per Componenti e Servizi Web<br>
 * Date: May 2018<br><br>
 * giovanni.bonetta@edu.unito.it<br>
 * riccardo.renzulli@edu.unito.it<br>
 * gabriele.sartor@edu.unito.it<br><br>
 * 
 * bean with the business logic related to Trip
 */
@Stateless
public class TripBean implements TripBeanLocal {

    @EJB
    private DayItineraryFacadeLocal dayItineraryFacade;

    @EJB
    private RouteFacadeLocal routeFacade;

    @EJB
    private GoogleDirectionsBean dirFacade;

    @EJB
    private TripFacadeLocal tripFacade;
    
    @EJB
    private HotelBeanLocal hotelFacade;
    
    @EJB
    private PlaceFacadeLocal placeFacade;
    
    /**
     * Given the interesting places to be visited and the number of days
     * return an arraylist for each cluster containing the indexes of the
     * places belonging to the clusters.
     * @param interestingPlaces list of interesting Places objects
     * @param dayTrips number of days
     * @param hotel the Hotel choosed for the trip
     * @return Trip object 
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
                Route route = createRouteFromPlaces(place1, place2, dayItinerary);
                legs.add(route);
            }
            dayItinerary.setLegs(legs);
            dayItinerary.setTrip(trip);
            itinerary.add(dayItinerary);
        }
        trip.setItineraries(itinerary);
        return trip;
    }

    private Route createRouteFromPlaces(Place departure, Place destination, DayItinerary dayItinerary) throws IOException {
        Route route = dirFacade.getRoute(departure, destination, "driving", "now");
        route.setDayItinerary(dayItinerary);
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

    /**
     * persist the trip in the database
     * @param myTrip the trip object to be saved
     */
    @Override
    public void saveTrip(Trip myTrip) {
        for(int i=0; i<myTrip.getItineraries().size(); i++) {
            for(Place place : myTrip.getDayPlaces(i))
                placeFacade.create(place);
        }
        Hotel hotel = myTrip.getHotel();
        if (hotel != null) hotelFacade.createHotel(myTrip.getHotel());
        tripFacade.create(myTrip);
    }
    
    /**
     * remove the specific trip from the database
     * @param myTrip the trip to be deleted
     */
    @Override
    public void removeTrip(Trip myTrip) {
        tripFacade.remove(myTrip);
    }

    /**
     * gets all the trips owned by a specific user
     * @param owner the user owner
     * @return a List of Trip objects 
     */
    @Override
    public List<Trip> getAllTripByOwner(User owner) {
        List<Trip> trips = tripFacade.findTripsByOwner(owner);
        return trips;
    }

    /**
     * gets a specific trip owned by a specific user
     * @param owner the owner user
     * @param id the id of the trip to be returned
     * @return the trip Object 
     */
    @Override
    public Trip getTripByOwnerAndID(User owner, long id) {
        Trip trip = tripFacade.getTripByOwnerAndID(owner, id);
        return trip;
    }

    private Place fromHotelToPlace(Hotel hotel) {
        Place hotelPlace = new Place();
        hotelPlace.setName(hotel.getName());
        hotelPlace.setAddress(hotel.getAddress());
        hotelPlace.setDescription("");
        hotelPlace.setLat(hotel.getLatitude());
        hotelPlace.setLng(hotel.getLongitude());
        hotelPlace.setId(hotel.getId()); //???????
        hotelPlace.setPhotosUrl("https://www.hotel-city47.com/wp-content/blogs.dir/864/files/deslizantehome/Hotel_city_habitacion_matrimonio_03.jpg");
        return hotelPlace;
    }

    /**
     * gets basic informations about all the trips owned by the specific user
     * @param owner the owner user
     * @return ArrayList containing one hasmap for every trip. the hasmap contains information like: departure city, trip image, dates
     */
    @Override
    public ArrayList<HashMap<String, String>> getBasicInfoTripsByOwner(User owner) {
        List<Object[]> listSearch = tripFacade.getBasicInfoTripsByOwner(owner);
        
        ArrayList<HashMap<String, String>> listInfoTrips = new ArrayList<HashMap<String, String>>();
        for (Object[] obj : listSearch) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("idTrip", ((Long)obj[1]).toString());
            map.put("destination", ((Search)obj[0]).getDestinationCity());
            map.put("departureDate", ((Search)obj[0]).getDepartureDate().toString());
            map.put("arrivalDate", ((Search)obj[0]).getReturnDate().toString());
            
            Long idTrip = ((Long)obj[1]);
            Long dayItID = dayItineraryFacade.getFirstDayItineraryID(idTrip);
            String placeIMGUrl = routeFacade.findSecondPlaceIMG(dayItID);
            map.put("placeIMGUrl", placeIMGUrl);
            
            listInfoTrips.add(map);
        }
        return listInfoTrips;
    }
 
}
