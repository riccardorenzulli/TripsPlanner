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
 *
 * @author riccardo
 */
@Stateless
public class PlaceBean implements PlaceBeanLocal {

    @EJB
    private PlaceFacadeLocal placeFacade;

    @Override
    public void updatePlace(Memory memory, Place place, boolean add) {
        if (add) place.getMemories().add(memory);
        else place.getMemories().remove(memory);
        placeFacade.edit(place);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
