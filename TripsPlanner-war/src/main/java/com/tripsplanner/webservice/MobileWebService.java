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
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * REST Web Service
 *
 * @author riccardo
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
    
    @GET
    @Path("mytrips")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Trip> getAllTripByOwner() {
        User user = (User) req.getSession().getAttribute("user");
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
                    req.getSession().setAttribute("user", user);
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
