/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.model.bean;

import java.util.HashMap;
import javax.ejb.Stateless;

/**
 *
 * @author the-silent-fox
 */
@Stateless
public class SearchBean implements SearchBeanLocal {

    @Override
    public void performSearch(HashMap<String, String> mapSearch) {
        /*Get the parameters from the search box*/
        System.out.print("\n\nHello by SearchBean!");
        for(String key : mapSearch.keySet()) {
            System.out.println(mapSearch.get(key));
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
