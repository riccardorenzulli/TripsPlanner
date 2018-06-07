/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.model.facade;

import com.tripsplanner.model.entity.DayItinerary;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
 * specific DayItineray facade 
 */

@Stateless
public class DayItineraryFacade extends AbstractFacade<DayItinerary> implements DayItineraryFacadeLocal {

    @PersistenceContext(unitName = "TripsPlanner-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DayItineraryFacade() {
        super(DayItinerary.class);
    }

    /**
     * retrive the first day itineray Id from the database
     * @param tripID the id of the trip which owns the day itinerary
     * @return the first day itinerary id
     */
    public Long getFirstDayItineraryID(Long tripID) {
        return em.createNamedQuery("DayItinerary.getFirstDayItineraryID", Long.class)
                .setParameter("tripID", tripID).getResultList().get(0);
    }
    
}
