/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.model.bean;

import com.tripsplanner.model.entity.Search;
import com.tripsplanner.model.facade.SearchFacadeLocal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Authors: Giovanni Bonetta, Riccardo Renzulli, Gabriele Sartor<br>
 * Università degli Studi di Torino<br>
 * Department of Computer Science<br>
 * Sviluppo Software per Componenti e Servizi Web<br>
 * Date: May 2018<br><br>
 * <p/>
 * giovanni.bonetta@edu.unito.it<br>
 * riccardo.renzulli@edu.unito.it<br>
 * gabriele.sartor@edu.unito.it<br><br>
 */

@Stateless
public class SearchBean implements SearchBeanLocal {
    
    @EJB
    private SearchFacadeLocal search;

    @Override
    public Search createSearch(HashMap<String, String> mapSearch) {
        /*Get the parameters from the search box*/
        System.out.print("\n\nHello by SearchBean!");
        for(String key : mapSearch.keySet()) {
            System.out.println(mapSearch.get(key));
        }
        
        Search tmpSearch = new Search();
        tmpSearch.setDepartureCity(mapSearch.get("departure_city"));
        tmpSearch.setDestinationCity(mapSearch.get("destination_city"));
        
        /*Departure date*/
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        Date parsed = null;
        try {
            parsed = format.parse(mapSearch.get("departure_date"));
        } catch (ParseException ex) {
            Logger.getLogger(SearchBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.sql.Date departureDate = new java.sql.Date(parsed.getTime());
        tmpSearch.setDepartureDate(departureDate);
        
        /*Return date*/
        try {
            parsed = format.parse(mapSearch.get("return_date"));
        } catch (ParseException ex) {
            Logger.getLogger(SearchBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.sql.Date returnDate = new java.sql.Date(parsed.getTime());
        tmpSearch.setReturnDate(returnDate);
        
        tmpSearch.setNumAdult(Integer.parseInt(mapSearch.get("adult_count")));
        tmpSearch.setNumChildren(Integer.parseInt(mapSearch.get("child_count")));
        tmpSearch.setMuseums(mapSearch.get("museums").equals("YES"));
        tmpSearch.setArt(mapSearch.get("art").equals("YES"));
        tmpSearch.setNature(mapSearch.get("nature").equals("YES"));
        tmpSearch.setShopping(mapSearch.get("shopping").equals("YES"));
        tmpSearch.setNightLife(mapSearch.get("night_life").equals("YES"));
        
        search.create(tmpSearch);
        
        return tmpSearch;
        
        
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
