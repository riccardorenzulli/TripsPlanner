/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.model.facade;

import com.tripsplanner.model.entity.DayItinerary;
import java.math.BigInteger;
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
 * local day itinerary interface,
 * expose CRUD operations and the specific day itinerary operations
 */

@Local
public interface DayItineraryFacadeLocal {

    void create(DayItinerary dayItinerary);

    void edit(DayItinerary dayItinerary);

    void remove(DayItinerary dayItinerary);

    DayItinerary find(Object id);

    List<DayItinerary> findAll();

    List<DayItinerary> findRange(int[] range);
    
    /**
     * retrive the first day itineray Id from the database
     * @param tripID the id of the trip which owns the day itinerary
     * @return the first day itinerary id
     */
    Long getFirstDayItineraryID(Long tripID);

    int count();
    
}
