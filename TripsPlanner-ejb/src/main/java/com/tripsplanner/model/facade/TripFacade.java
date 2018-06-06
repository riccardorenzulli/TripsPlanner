/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.model.facade;

import com.tripsplanner.model.entity.Search;
import com.tripsplanner.model.entity.Trip;
import com.tripsplanner.model.entity.User;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

@Stateless
public class TripFacade extends AbstractFacade<Trip> implements TripFacadeLocal {

    @PersistenceContext(unitName = "TripsPlanner-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TripFacade() {
        super(Trip.class);
    }
    
    public List<Trip> findTripsByOwner(User owner){
        return em.createNamedQuery("Trip.findByOwner", Trip.class)
                .setParameter("owner", owner).getResultList();
    }

    @Override
    public Trip getTripByOwnerAndID(User owner, long id) {
        return em.createNamedQuery("Trip.findByOwnerAndId", Trip.class)
                .setParameter("owner", owner)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public List<Object[]> getBasicInfoTripsByOwner(User owner) {
        return em.createNamedQuery("Trip.findBasicInfoOwner", Object[].class)
                .setParameter("owner", owner).getResultList();
    }
    
}
