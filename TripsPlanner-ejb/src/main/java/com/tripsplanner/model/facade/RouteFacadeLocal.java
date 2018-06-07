/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.model.facade;

import com.tripsplanner.model.entity.Route;
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
 * route facade local interface
 * exposes CRUD operation for Route 
 */

@Local
public interface RouteFacadeLocal {

    void create(Route route);

    void edit(Route route);

    void remove(Route route);

    Route find(Object id);

    List<Route> findAll();

    List<Route> findRange(int[] range);

    int count();
    
    /**
     * return the second image url for the provided day itinerary
     * @param dayItID the dayitinerary Id
     * @return the image url
     */
    String findSecondPlaceIMG(Long dayItID);
    
}
