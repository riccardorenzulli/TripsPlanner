/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.webservice;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tripsplanner.model.bean.LoginBeanLocal;
import com.tripsplanner.model.bean.TripBeanLocal;
import com.tripsplanner.model.entity.DayItinerary;
import com.tripsplanner.model.entity.Route;
import com.tripsplanner.model.entity.User;
import com.tripsplanner.model.entity.Trip;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.QueryParam;

/**
 * Authors: Giovanni Bonetta, Riccardo Renzulli, Gabriele Sartor<br>
 * Università degli Studi di Torino<br>
 * Department of Computer Science<br>
 * Sviluppo Software per Componenti e Servizi Web<br>
 * Date: May 2018<br><br>
 * giovanni.bonetta@edu.unito.it<br>
 * riccardo.renzulli@edu.unito.it<br>
 * gabriele.sartor@edu.unito.it<br><br>
 * 
 * implementation of restfull webservices 
 */
@Path("/")
public class MobileWebService {

    LoginBeanLocal loginBean = lookupLoginBeanLocal();

    TripBeanLocal tripBean = lookupTripBeanLocal();
    
    

    @Context
    private HttpServletRequest req;
    

    /**
     * Creates a new instance of MobileWebService
     */
    public MobileWebService() {
    }
    
    /**
     * gets all the trips owned by a specific user
     * 
     * @param id the user owner id
     * @return ArrayList of Trips objects 
     */
    @GET
    @Path("mytrips")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Trip> getAllTripByOwner(
        @QueryParam("id") String id) {
        
        User user = new User();
        user.setId(Long.parseLong(id));
        ArrayList<Trip> trips = new ArrayList<Trip>(tripBean.getAllTripByOwner(user));
        
        for (Trip trip : trips) {
            trip.getOwner().setTrips(null);
            //trip.getOwner().setBelongingTrips(null);
            for(User collaborator : trip.getCollaborators()) {
                collaborator.setTrips(null);
                //collaborator.setBelongingTrips(null);
            }
            for (DayItinerary it : trip.getItineraries()) {
                it.setTrip(null);
                for (Route route: it.getLegs())
                    route.setDayItinerary(null);
            }
        }
        
        //Gson gson = new GsonBuilder().create();
        //String json = gson.toJson(trips);
        //JSONObject jsonObj = new JSONObject(json);
        
        return trips;
    }
    
    /**
     * get general informations about all the trips owned by a user
     * @param id the user owner id
     * @return ArrayList of hashmap, every hashmap contains basic informations about a trip, like the image of the second place in the first dayitinerary, the dates of the trip and the departure city
     */
    @GET
    @Path("mybasictrips")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<HashMap<String, String>> getBasicInfoTripsByOwner(
        @QueryParam("id") String id) {
        
        User user = new User();
        user.setId(Long.parseLong(id));
        ArrayList<HashMap<String, String>> listInfoTrips = new ArrayList<HashMap<String, String>>(tripBean.getBasicInfoTripsByOwner(user));
        
        return listInfoTrips;
    }
    
    /**
     * get a specific trip owned by a specific user
     * @param userID the owner id
     * @param id the trip id
     * @return Trip, the specific trip object
     */
    @GET
    @Path("trip")
    @Produces(MediaType.APPLICATION_JSON)
    public Trip getTripByID(
        @QueryParam("userID") String userID,
        @QueryParam("id") String id) {
        
        User user = new User();
        user.setId(Long.parseLong(userID));
        
        Trip trip = tripBean.getTripByOwnerAndID(user, Long.parseLong(id));
                
        trip.getOwner().setTrips(null);
            //trip.getOwner().setBelongingTrips(null);
            for(User collaborator : trip.getCollaborators()) {
                collaborator.setTrips(null);
                //collaborator.setBelongingTrips(null);
            }
            
            for (DayItinerary it : trip.getItineraries()) {
                it.setTrip(null);
                for (Route route: it.getLegs())
                    route.setDayItinerary(null);
            }
            
        return trip;
    }
    
    
    /**
     * validate a GoogleUser, if the user is present in the database it is returned, 
     * otherwise a new user is created with the provided informations and saved in the database
     * @param type specifies if the user is a Google or Facebook one
     * @param email the user email
     * @param name the user name
     * @param surname the user surname
     * @param imgURL the user image url
     * @param id the user id
     * @return the validated user
     */
    @GET
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    public User login(
            @QueryParam("type") String type,
            @QueryParam("email") String email,
            @QueryParam("name") String name,
            @QueryParam("surname") String surname,
            @QueryParam("imgURL") String imgURL,
            @QueryParam("id") String id) {
        
        User user = null;
        
        switch (type) {
                case "google":
                    HashMap<String, String> hashMap = new HashMap<String, String>();
                    hashMap.put("email", email);
                    hashMap.put("name", name);
                    hashMap.put("surname", surname);
                    hashMap.put("imgURL", imgURL);
                    hashMap.put("id", id);
                    
                    user = loginBean.validateGoogleUser(hashMap);
        }
                    
        return user;
    }
    
    private TripBeanLocal lookupTripBeanLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (TripBeanLocal) c.lookup("java:global/TripsPlanner-ear-1.0-SNAPSHOT/TripsPlanner-ejb-1.0-SNAPSHOT/TripBean!com.tripsplanner.model.bean.TripBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private LoginBeanLocal lookupLoginBeanLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (LoginBeanLocal) c.lookup("java:global/TripsPlanner-ear-1.0-SNAPSHOT/TripsPlanner-ejb-1.0-SNAPSHOT/LoginBean!com.tripsplanner.model.bean.LoginBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
