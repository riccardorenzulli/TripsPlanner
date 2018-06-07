package com.tripsplanner.model.bean;

import com.tripsplanner.model.entity.Hotel;
import com.tripsplanner.model.entity.Place;
import com.tripsplanner.model.entity.Trip;
import com.tripsplanner.model.entity.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Local;

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
 * TripBean local interface
 * exposes CRUD operations and specific Trip operations for the Trip
 */

@Local
public interface TripBeanLocal {
    
    /**
     * Given the interesting places to be visited and the number of days
     * return an arraylist for each cluster containing the indexes of the
     * places belonging to the clusters.
     * @param interestingPlaces list of interesting Places objects
     * @param dayTrips number of days
     * @param hotel the Hotel choosed for the trip
     * @return Trip object 
     */
    Trip buildTrip(List<Place> interestingPlaces, int dayTrips, Hotel hotel);
    
    /**
     * persist the trip in the database
     * @param myTrip the trip object to be saved
     */
    void saveTrip(Trip myTrip);
    
    /**
     * remove the specific trip from the database
     * @param myTrip the trip to be deleted
     */
    void removeTrip(Trip myTrip);
    
    /**
     * gets all the trips owned by a specific user
     * @param owner the user owner
     * @return a List of Trip objects 
     */
    List<Trip> getAllTripByOwner(User owner);
    
    /**
     * gets a specific trip owned by a specific user
     * @param owner the owner user
     * @param id the id of the trip to be returned
     * @return the trip Object 
     */
    Trip getTripByOwnerAndID(User owner, long id);
    
    /**
     * gets basic informations about all the trips owned by the specific user
     * @param owner the owner user
     * @return ArrayList containing one hasmap for every trip. the hasmap contains information like: departure city, trip image, dates
     */
    ArrayList<HashMap<String, String>> getBasicInfoTripsByOwner(User owner);
    
}