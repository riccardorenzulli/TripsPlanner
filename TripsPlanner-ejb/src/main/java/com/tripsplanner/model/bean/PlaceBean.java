/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.model.bean;

import com.tripsplanner.model.entity.Memory;
import com.tripsplanner.model.entity.Place;
import com.tripsplanner.model.facade.PlaceFacadeLocal;
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
 * bean with the business logic related to places
 */
@Stateless
public class PlaceBean implements PlaceBeanLocal {

    @EJB
    private PlaceFacadeLocal placeFacade;

    /**
     * update a place with the provided memory
     * 
     * @param memory the memory to be added or removed
     * @param place the owner of the memory
     * @param add if true the memory is added, otherwise removed
     */
    @Override
    public void updatePlace(Memory memory, Place place, boolean add) {
        if (add) place.getMemories().add(memory);
        else place.getMemories().remove(memory);
        placeFacade.edit(place);
    }

    
}
