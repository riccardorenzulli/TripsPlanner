/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.util;

import com.tripsplanner.model.entity.Search;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import org.json.JSONObject;

/**
 *
 * @author the-silent-fox
 */
public class GoogleAPI {
    
    private static final String api_key = "AIzaSyAnhWd3kTxtx-49mP3x8SiNIvH3XZKL-Wo";
    
    public static JSONObject getInterestingPlaces(Search search) throws IOException {
        JSONObject interestingPlacesJson = getInterestingPlaces(search.getDestinationCity());
        return null;
    }
    
    private static JSONObject getInterestingPlaces(String city) throws ProtocolException, IOException {
        String url = "https://maps.googleapis.com/maps/api/place/textsearch/json?";
	String parameters = "query=point+of+interests+in+"+city+"&key=" + api_key;
        
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
            System.out.println(line);
            sb.append(line);
            line = read.readLine();
        }

        JSONObject json = new JSONObject(sb.toString());
        System.out.println(json);
        
        return json;      
    }
    
    private static JSONObject getInterestingPlaces(String city, String type) throws ProtocolException, IOException {
        String url = "https://maps.googleapis.com/maps/api/place/textsearch/json?";
	String parameters = "query="+type+"+in+"+city+"&key=" + api_key;
        
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
            System.out.println(line);
            sb.append(line);
            line = read.readLine();
        }

        JSONObject json = new JSONObject(sb.toString());
        System.out.println(json);
        
        return json;      
    }
    
}
