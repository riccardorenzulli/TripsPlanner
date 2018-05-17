/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.model.bean;

import com.tripsplanner.config.Config;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import org.json.JSONObject;

/**
 *
 * @author riccardo
 */
@Stateless
@LocalBean
public class GoogleDirectionsBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public JSONObject getDirections(String departurePlaceID, String destinationPlaceID, String m, String departureTime) throws MalformedURLException, IOException {
        String url = "https://maps.googleapis.com/maps/api/directions/json?";
        String parameters = "origin=place_id:" + departurePlaceID + "&destination=place_id:" + departurePlaceID;
        String mode = "&mode=" + m;
        String depTime = "&departure_time=" + departureTime;
        String key = "&key=" + Config.google_key;
        
        String query = new StringBuilder(url).append(parameters).append(mode).append(depTime).append(key).toString();
        
        URL obj = new URL(query);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");

        BufferedReader read = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String line = read.readLine();
        StringBuilder sb = new StringBuilder();

        while(line!=null) {
            System.out.println(line);
            sb.append(line);
            line = read.readLine();
        }

        JSONObject json = new JSONObject(sb.toString());
        
        return json;
    }
    
}
