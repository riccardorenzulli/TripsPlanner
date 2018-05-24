/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.model.bean;

import com.tripsplanner.model.entity.Hotel;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.net.ssl.HttpsURLConnection;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;
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
public class AmadeusAPIBean {
    
    @EJB
    private ApiKeysBean apiKeysBean;
    private String api_key = apiKeysBean.keys.get("amadeus_api");
    private String client_secret = apiKeysBean.keys.get("amadeus_client_secret");
    
    private String mmggyy_to_yymmgg(String date) {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        DateFormat dff = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate;
        String newDateString = "";
        try {
            startDate = df.parse(date);
            newDateString = dff.format(startDate);
            System.out.println(newDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return newDateString;
    }
    
    private String getIATAfromName(String name){
        String Iata = StringUtils.substringBetween(name, "[","]");
        return Iata;
    }
    
    private String getAmadeusToken() throws Exception {

        String url = "https://test.api.amadeus.com/v1/security/oauth2/token";
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = "grant_type=client_credentials&client_id=" + api_key + "&client_secret="+ client_secret;
        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        JSONObject jsonObj = new JSONObject(response.toString());
        String token = jsonObj.getString("access_token");

        return token;
    }

    // Where can I fly to from Paris?
    public JSONObject getInspirationFlight(String departure_city_IATA, String departure_date) throws Exception{
        String amadeus_token = getAmadeusToken();
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .header("authorization", "Bearer " + amadeus_token)
                .url("https://test.api.amadeus.com/v1/shopping/flight-destinations?origin=" + departure_city_IATA + "&departureDate="+ departure_date)
                .build();
        
        Response response = client.newCall(request).execute();
        String response_body = response.body().string();
        JSONObject jsonObj = new JSONObject(response_body);
        return jsonObj;
    }
    
    //I know where I want to fly, the dates and duration, what are the best flight deals?
    public JSONObject getLowFareFlight(String departure_IATA, String destination_IATA,  String departure_date) throws Exception{
        String amadeus_token = getAmadeusToken();
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .header("authorization", "Bearer " + amadeus_token)
                .url("https://test.api.amadeus.com/v1/shopping/flight-offers?origin=" + departure_IATA + "&destination="+ destination_IATA +"&departureDate="+ departure_date)
                .build();
        
        Response response = client.newCall(request).execute();
        String response_body = response.body().string();
        JSONObject jsonObj = new JSONObject(response_body);
        return jsonObj;
    }
    
    // What are the best hotel offers during my trip?
    public JSONObject getHotelsJson(String destination_IATA,  String departure_date, String return_date) throws Exception {
        String amadeus_token = getAmadeusToken();
//        System.out.println("amadeus token: " + amadeus_token);
//        OkHttpClient client = new OkHttpClient();
//
//        Request request = new Request.Builder()
//                .header("authorization", "Bearer " + amadeus_token)
//                .url("https://test.api.amadeus.com/v1/shopping/hotel-offers?cityCode=" + destination_IATA + "&checkInDate=" + departure_date + "&checkOutDate=" + return_date) //+"&page%5Blimit%5D=5")
//                .build();
//
//        Response response = client.newCall(request).execute();
//        String response_body = response.body().string();
        String requestUrl = "https://test.api.amadeus.com/v1/shopping/hotel-offers?cityCode=" + destination_IATA + "&checkInDate=" + departure_date + "&checkOutDate=" + return_date +"&bestRateOnly=true&view=FULL"; //+"&page%5Blimit%5D=5"
        JSONObject jsonObj = runConnection(requestUrl, amadeus_token);

        return jsonObj;
    }
    
    public ArrayList<Hotel> getHotels(String destination_IATA,  String departure_date, String return_date) throws Exception{
        String dep_date = mmggyy_to_yymmgg(departure_date);
        String ret_date = mmggyy_to_yymmgg(return_date);
        String Iata = getIATAfromName(destination_IATA);
        JSONObject json = getHotelsJson(Iata, dep_date, ret_date);
        System.out.println(json);
        ArrayList<Hotel> hotels = new ArrayList<Hotel>();
        JSONArray JsonHotelArray = json.getJSONArray("data");
        int len = JsonHotelArray.length();
        
        for(int i=0; i<len; i++){
            JSONObject h = JsonHotelArray.getJSONObject(i);
            hotels.add(Hotel.fromJsonToHotel(h));
        }

        return hotels;
    }
    
    private JSONObject runConnection(String requestUrl, String amadeus_token) throws MalformedURLException, IOException{
        URL obj = new URL(requestUrl);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        //add request header
        con.setRequestProperty("authorization", "Bearer " + amadeus_token);

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
        return json;
    }
    
}