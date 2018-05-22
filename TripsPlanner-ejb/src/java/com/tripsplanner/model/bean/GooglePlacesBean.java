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
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import org.json.JSONArray;
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
public class GooglePlacesBean {
    
    @EJB
    private ApiKeysBean apiKeysBean;
    private String api_key = apiKeysBean.keys.get("google_places_api");
    
    private JSONObject getInterestingPlacesJSON(String city) throws ProtocolException, IOException {
        System.out.println("google places api key "+ api_key);
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
    
    private JSONObject getInterestingPlacesJSON(String city, String type) throws ProtocolException, IOException {
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
    
    public ArrayList<Place> getInterestingPlaces(Search search) throws IOException {
        JSONObject jsonResult = getInterestingPlacesJSON(search.getDestinationCity());
        ArrayList<Place> places = fromJsonToListPlace(jsonResult);
        
        if(search.isMuseums()) {
            JSONObject obj = getInterestingPlacesJSON(search.getDestinationCity(), "museum");
            places.addAll(fromJsonToListPlace(obj));
        }
        if(search.isArt()) {
            JSONObject obj = getInterestingPlacesJSON(search.getDestinationCity(), "art");
            places.addAll(fromJsonToListPlace(obj));
        }
        if(search.isNature()) {
            JSONObject obj = getInterestingPlacesJSON(search.getDestinationCity(), "park");
            places.addAll(fromJsonToListPlace(obj));
        }
        if(search.isShopping()) {
            JSONObject obj = getInterestingPlacesJSON(search.getDestinationCity(), "shopping");
            places.addAll(fromJsonToListPlace(obj));
        }
        if(search.isNightLife()) {
            JSONObject obj = getInterestingPlacesJSON(search.getDestinationCity(), "club");
            places.addAll(fromJsonToListPlace(obj));
        }
        
        return places;
    } 
    
    public String getPhotoFromReference(String photoReference) throws IOException {
        return "https://maps.googleapis.com/maps/api/place/photo?maxwidth=640&maxheight=425&photoreference="+photoReference+"&key="+api_key;
    }
    
    public Place fromJsonToPlace(JSONObject jsonObj) {
        Place place = new Place();
        
        place.setName(jsonObj.getString("name"));
        place.setAddress(jsonObj.getString("formatted_address"));
        
        try {
            place.setDescription(WikipediaAPIBean.getDescription(place.getName()));
        } catch (Exception e) { place.setDescription(""); }
        
        place.setLat(jsonObj.getJSONObject("geometry").getJSONObject("location").getFloat("lat"));
        place.setLng(jsonObj.getJSONObject("geometry").getJSONObject("location").getFloat("lng"));
        place.setGoogleID(jsonObj.getString("id"));
        place.setGooglePlaceID(jsonObj.getString("place_id"));
        try {
            String photoReference = jsonObj.getJSONArray("photos").getJSONObject(0).getString("photo_reference");
            place.setPhotosUrl(getPhotoFromReference(photoReference));
        } catch(Exception e) { System.out.println("Photos not found"); }
        try {
            place.setRating(jsonObj.getFloat("rating"));
        } catch(Exception e) { System.out.println("Rating not found"); }
        
        JSONArray typesJson = jsonObj.getJSONArray("types");
        ArrayList<String> typesList = new ArrayList<String>();
        for(int i=0; i<typesJson.length(); i++)
            typesList.add(typesJson.getString(i));
        place.setTypes(typesList);
        
        return place;
    }
    
    public ArrayList<Place> fromJsonToListPlace(JSONObject jsonResult) {
        ArrayList<Place> places = new ArrayList<Place>();
        JSONArray results = jsonResult.getJSONArray("results");
        
        for(int i=0; i<5 && i<results.length(); i++) {
            JSONObject jsonObj = results.getJSONObject(i);
            places.add(fromJsonToPlace(jsonObj));
        }
        return places;
    }
}
