/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.model.bean;

import com.tripsplanner.model.entity.Place;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author the-silent-fox
 */
@Local
public interface TripBeanLocal {
    
    ArrayList<ArrayList<Integer>> buildTrip(List<Place> interestingPlaces, int dayTrips);
    
}
