/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.model.bean;

import com.tripsplanner.model.entity.Hotel;
import com.tripsplanner.model.facade.HotelFacade;
import com.tripsplanner.model.facade.HotelFacadeLocal;
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
 * bean with the business logic related to hotels
 */
@Stateless
public class HotelBean implements HotelBeanLocal {
    
    @EJB
    private HotelFacadeLocal hotelFacade;

    /**
     * persist an hotel in the database
     * @param hotel the hotel to be created
     */
    @Override
    public void createHotel(Hotel hotel) {
        hotelFacade.create(hotel);
    }

}
