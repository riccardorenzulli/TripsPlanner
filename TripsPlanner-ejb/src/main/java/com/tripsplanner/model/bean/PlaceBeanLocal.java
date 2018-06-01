/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.model.bean;

import com.tripsplanner.model.entity.Memory;
import com.tripsplanner.model.entity.Place;
import javax.ejb.Local;

/**
 *
 * @author riccardo
 */
@Local
public interface PlaceBeanLocal {

    void updatePlace(Memory memory, Place place);
    
}
