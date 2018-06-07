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
 * Authors: Giovanni Bonetta, Riccardo Renzulli, Gabriele Sartor<br>
 * Università degli Studi di Torino<br>
 * Department of Computer Science<br>
 * Sviluppo Software per Componenti e Servizi Web<br>
 * Date: May 2018<br><br>
 * giovanni.bonetta@edu.unito.it<br>
 * riccardo.renzulli@edu.unito.it<br>
 * gabriele.sartor@edu.unito.it<br><br>
 * 
 * local interface of place bean
 */
@Local
public interface PlaceBeanLocal {

    /**
     * update the place
     * 
     * @param memory the memory related to the place
     * @param place the place, memory owner
     * @param add if the memory has to be added or removed
     */
    void updatePlace(Memory memory, Place place, boolean add);
    
}
