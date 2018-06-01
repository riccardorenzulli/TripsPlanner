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
 *
 * @author the-silent-fox
 */
@Stateless
public class HotelBean implements HotelBeanLocal {
    
    @EJB
    private HotelFacadeLocal hotelFacade;

    @Override
    public void createHotel(Hotel hotel) {
        hotelFacade.create(hotel);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
