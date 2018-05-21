/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.model.bean;

import com.tripsplanner.model.entity.Place;
import com.tripsplanner.model.entity.Search;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author the-silent-fox
 */

@Stateless
@LocalBean
public class GooglePlacesBean {
    
    private static final String api_key = "AIzaSyAnhWd3kTxtx-49mP3x8SiNIvH3XZKL-Wo";
    
    private static JSONObject getInterestingPlacesJSON(String city) throws ProtocolException, IOException {
        String[] cityElements = city.split("\\[");
        String cityElem1 = cityElements[0].replaceAll("[^A-Za-z0-9]", "+");
        String cityElem2 = cityElements[1].replaceAll("[^A-Za-z0-9]", "+");
        String stringCity = cityElem1 + cityElem2;
        System.out.println(stringCity);
        
        String url = "https://maps.googleapis.com/maps/api/place/textsearch/json?";
	String parameters = "query=what+to+see+in+"+stringCity+"&key=" + api_key;
        
        String requestUrl = url + parameters;
        
        URL obj = new URL(requestUrl);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        //add request header
        //con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + requestUrl);
        System.out.println("Response Code : " + responseCode);

        BufferedReader read = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String line = read.readLine();
        StringBuilder sb = new StringBuilder();

        while(line!=null) {
            //System.out.println(line);
            sb.append(line);
            line = read.readLine();
        }

        JSONObject json = new JSONObject(sb.toString());
        //System.out.println(json);
        
        return json;      
    }
    
    private static JSONObject getInterestingPlacesJSON(String city, String type) throws ProtocolException, IOException {
        String[] cityElements = city.split("\\[");
        String cityElem1 = cityElements[0].replaceAll("[^A-Za-z0-9]", "+");
        String cityElem2 = cityElements[1].replaceAll("[^A-Za-z0-9]", "+");
        String stringCity = cityElem1 + cityElem2;
        
        String url = "https://maps.googleapis.com/maps/api/place/textsearch/json?";
	String parameters = "query="+type+"+in+"+stringCity+"&key=" + api_key;
        
        String requestUrl = url + parameters;
        
        URL obj = new URL(requestUrl);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        //add request header
        //con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + requestUrl);
        System.out.println("Response Code : " + responseCode);

        BufferedReader read = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String line = read.readLine();
        StringBuilder sb = new StringBuilder();

        while(line!=null) {
            //System.out.println(line);
            sb.append(line);
            line = read.readLine();
        }

        JSONObject json = new JSONObject(sb.toString());
        //System.out.println(json);
        
        return json;      
    }
    
    public static ArrayList<Place> getInterestingPlaces(Search search) throws IOException {
        JSONObject jsonResult = getInterestingPlacesJSON(search.getDestinationCity());
        ArrayList<Place> places = Place.fromJsonToListPlace(jsonResult);
        
        if(search.isMuseums()) {
            JSONObject obj = getInterestingPlacesJSON(search.getDestinationCity(), "museum");
            places.addAll(Place.fromJsonToListPlace(obj));
        }
        if(search.isArt()) {
            JSONObject obj = getInterestingPlacesJSON(search.getDestinationCity(), "art");
            places.addAll(Place.fromJsonToListPlace(obj));
        }
        if(search.isNature()) {
            JSONObject obj = getInterestingPlacesJSON(search.getDestinationCity(), "park");
            places.addAll(Place.fromJsonToListPlace(obj));
        }
        if(search.isShopping()) {
            JSONObject obj = getInterestingPlacesJSON(search.getDestinationCity(), "shopping");
            places.addAll(Place.fromJsonToListPlace(obj));
        }
        if(search.isNightLife()) {
            JSONObject obj = getInterestingPlacesJSON(search.getDestinationCity(), "club");
            places.addAll(Place.fromJsonToListPlace(obj));
        }
        
        return places;
    } 
    
    public static String getPhotoFromReference(String photoReference) throws IOException {
        return "https://maps.googleapis.com/maps/api/place/photo?maxwidth=640&maxheight=425&photoreference="+photoReference+"&key="+api_key;
    }
    
}
