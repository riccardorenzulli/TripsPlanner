/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.model.facade;

import com.tripsplanner.model.entity.Hotel;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author the-silent-fox
 */
@Local
public interface HotelFacadeLocal {

    void create(Hotel hotel);

    void edit(Hotel hotel);

    void remove(Hotel hotel);

    Hotel find(Object id);

    List<Hotel> findAll();

    List<Hotel> findRange(int[] range);

    int count();
    
}
