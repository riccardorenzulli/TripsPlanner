/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.model.bean;

import com.tripsplanner.model.entity.Hotel;
import com.tripsplanner.model.entity.Place;
import com.tripsplanner.model.entity.Trip;
import com.tripsplanner.model.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author the-silent-fox
 */
@Local
public interface TripBeanLocal {
    
    Trip buildTrip(List<Place> interestingPlaces, int dayTrips, Hotel hotel);
    
    void saveTrip(Trip myTrip);
    
    void removeTrip(Trip myTrip);
    
    List<Trip> getAllTripByOwner(User owner);
    
    Trip getTripByOwnerAndID(User owner, long id);
    
}