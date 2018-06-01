/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.model.facade;

import com.tripsplanner.model.entity.Trip;
import com.tripsplanner.model.entity.User;
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
public interface TripFacadeLocal {

    void create(Trip trip);

    void edit(Trip trip);

    void remove(Trip trip);

    Trip find(Object id);

    List<Trip> findAll();

    List<Trip> findRange(int[] range);

    int count();
    
    public List<Trip> findTripsByOwner(User owner);
    
    public Trip getTripByOwnerAndID(User owner, long id);
    
}
