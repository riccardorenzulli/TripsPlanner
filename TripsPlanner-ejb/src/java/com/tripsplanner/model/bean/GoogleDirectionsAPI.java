/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.model.bean;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import org.json.JSONObject;

/**
 *
 * @author riccardo
 */
@Stateless
@LocalBean
public class GoogleDirectionsAPI {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public JSONObject getDirections(String departurePlaceID, String destinationPlaceID) {
        return null;
    }
    
}
