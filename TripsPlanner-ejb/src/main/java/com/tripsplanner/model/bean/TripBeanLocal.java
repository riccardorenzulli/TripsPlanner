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
 * <p/>
 * giovanni.bonetta@edu.unito.it<br>
 * riccardo.renzulli@edu.unito.it<br>
 * gabriele.sartor@edu.unito.it<br><br>
 */

@Local
public interface TripBeanLocal {
    
    Trip buildTrip(List<Place> interestingPlaces, int dayTrips, Hotel hotel);
    
    void saveTrip(Trip myTrip);
    
    void removeTrip(Trip myTrip);
    
    List<Trip> getAllTripByOwner(User owner);
    
    Trip getTripByOwnerAndID(User owner, long id);
    
    ArrayList<HashMap<String, String>> getBasicInfoTripsByOwner(User owner);
    
}