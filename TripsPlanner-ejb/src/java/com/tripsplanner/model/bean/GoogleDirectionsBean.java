/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.model.bean;

import com.tripsplanner.model.entity.Place;
import com.tripsplanner.model.entity.Route;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import org.json.JSONObject;

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
@LocalBean
public class GoogleDirectionsBean {

    @EJB
    private ApiKeysBean apiKeysBean;
    private String api_key = apiKeysBean.keys.get("google_places_api");
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    private String getDirectionsQuery(Place departurePlace, Place destinationPlace, String travelMode, String departureTime) {
        String url = "https://maps.googleapis.com/maps/api/directions/json?";
        String parameters = "origin=place_id:" + departurePlace.getGooglePlaceID() + "&destination=place_id:" + destinationPlace.getGooglePlaceID();
        String mode = "&mode=" + travelMode;
        String depTime = "&departure_time=" + departureTime;
        String key = "&key=" + api_key;
        
        String query = new StringBuilder(url).append(parameters).append(mode).append(depTime).append(key).toString();
        
        return query;
    }
    
    private JSONObject getDirections(String query) throws MalformedURLException, IOException {        
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
    
    public Route getRoute(Place departurePlace, Place destinationPlace, String travelMode, String departureTime) throws IOException {
        
        String query = this.getDirectionsQuery(departurePlace, destinationPlace, travelMode, departureTime);
        JSONObject json = this.getDirections(query);
        
        Route route = new Route();
        
        route.setDeparturePlace(departurePlace);
        route.setArrivalPlace(destinationPlace);
        route.setTravelMode(travelMode);
        route.setQuery(query);
        
        JSONObject routesJson = (JSONObject)json.getJSONArray("routes").get(0);
                
        if (travelMode.equalsIgnoreCase("transit") && routesJson.keySet().contains("fare")) {
            JSONObject fareJSon = routesJson.getJSONObject("fare");
            route.setFareText(fareJSon.getString("text"));
            route.setFareValue(fareJSon.getDouble("value"));
        }
        
        JSONObject legsJson = (JSONObject)routesJson.getJSONArray("legs").get(0);
        
        JSONObject distanceJson = (JSONObject) legsJson.getJSONObject("distance");
        route.setDistanceText(distanceJson.getString("text"));
        route.setDistanceValue(distanceJson.getLong("value"));
        
        if (travelMode.equalsIgnoreCase("transit")) {
            JSONObject arrivalTimeJson = (JSONObject) legsJson.getJSONObject("arrival_time");
            route.setArrivalTimeText(arrivalTimeJson.getString("text"));
            route.setArrivalTimeValue(arrivalTimeJson.getLong("value"));
        }
        
        if (travelMode.equalsIgnoreCase("transit") && legsJson.keySet().contains("departure_time")) {
            JSONObject departureTimeJson = (JSONObject) legsJson.getJSONObject("departure_time");
            route.setDepartureTimeText(departureTimeJson.getString("text"));
            route.setDepartureTimeValue(departureTimeJson.getLong("value"));
        }
        
        else if ((travelMode.equalsIgnoreCase("driving") || travelMode.equalsIgnoreCase("walking")) && departureTime != null) {
            if (departureTime.equalsIgnoreCase("now")) route.setDepartureTimeValue(0);
            else route.setDepartureTimeValue(Long.parseLong(departureTime));
        }
        
        JSONObject durationJson;
        
        if (query.contains("departure_time") && travelMode.equalsIgnoreCase("driving")) {
            durationJson = (JSONObject) legsJson.getJSONObject("duration_in_traffic");
        }
        
        else {
            durationJson = (JSONObject) legsJson.getJSONObject("duration");
            route.setDurationText(durationJson.getString("text"));
            route.setDurationValue(durationJson.getLong("value"));
        }
        
        route.setDurationText(durationJson.getString("text"));
        route.setDurationValue(durationJson.getLong("value"));
        
        //System.out.println(route);

        return route;
    }

}
