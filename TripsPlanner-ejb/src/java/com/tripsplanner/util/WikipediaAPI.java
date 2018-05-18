/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONObject;

/**
 *
 * @author the-silent-fox
 */
public class WikipediaAPI {
    
    public static String getDescription(String name) throws MalformedURLException, IOException {
        String stringName = name.replace(' ', '_');
        String url = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=extracts&exchars=175&titles="+stringName;
        
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        //add request header
        //con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
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
        System.out.println(json);
        JSONObject pages = json.getJSONObject("query").getJSONObject("pages");
        String key = pages.keys().next();
        String description = pages.getJSONObject(key).getString("extract");
                
        return description.replaceAll("\\<[^>]*>","");
    }
    
}
