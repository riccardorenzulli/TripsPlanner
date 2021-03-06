/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.servlet;

import com.tripsplanner.model.bean.GoogleDirectionsBean;
import com.tripsplanner.model.bean.SearchBeanLocal;
import com.tripsplanner.model.entity.Place;
import com.tripsplanner.model.entity.Search;
import com.tripsplanner.model.bean.AmadeusAPIBean;
import com.tripsplanner.model.bean.GooglePlacesBean;
import com.tripsplanner.model.bean.HotelBean;
import com.tripsplanner.model.bean.HotelBeanLocal;
import com.tripsplanner.model.bean.TripBeanLocal;
import com.tripsplanner.model.entity.Hotel;
import com.tripsplanner.model.entity.Trip;
import com.tripsplanner.model.entity.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;

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
 * specific controller for calls related to the index.jsp view
 */

public class SearchServlet extends HttpServlet {

    @EJB
    private AmadeusAPIBean amadeusAPIBean;
    @EJB
    private GooglePlacesBean googlePlacesBean;
    @EJB
    private SearchBeanLocal searchBean;
    @EJB
    private GoogleDirectionsBean dirBean;
    @EJB
    private TripBeanLocal tripBean;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        switch(action == null ? "" : action) {
            case "search":
                goSearch(request, response);
                break;
            case "tripHotel":
                goTripHotel(request, response);
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void goSearch(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        
        HashMap<String, String> mapSearch = new HashMap<String, String>();
        
        String departureCity = request.getParameter("departure_city");
        String destinationCity = request.getParameter("destination_city");
        String departureDate = request.getParameter("departure_date");
        String returnDate = request.getParameter("return_date");
        String numAdult = request.getParameter("adult_count");
        String numChildren = request.getParameter("child_count");
        String museums = request.getParameter("museums") == null ? "NO" : "YES";
        String art = request.getParameter("art") == null ? "NO" : "YES";
        String nature = request.getParameter("nature") == null ? "NO" : "YES";
        String shopping = request.getParameter("shopping") == null ? "NO" : "YES";
        String nightLife = request.getParameter("night_life") == null ? "NO" : "YES";
        
        Float latitude = Float.parseFloat(request.getParameter("latitude"));
        Float longitude = Float.parseFloat(request.getParameter("longitude"));
        
        System.out.print("Hello by SearchServlet!\n");
        System.out.print("Departure: " + departureCity + "\nDestination: " + destinationCity);
        System.out.print("Departure date: " + departureDate + "\nDestination date: " + returnDate);
        System.out.print("Adult: " + numAdult + "\nChildren: " + numChildren);
        System.out.print("Checkbox: \n" + "Museums: " + museums + 
                "\nArt: " + art +
                "\nNature: " + nature +
                "\nShopping: " + shopping + 
                "\nNight life: " + nightLife);
        
        mapSearch.put("departure_city", departureCity);
        mapSearch.put("destination_city", destinationCity);
        mapSearch.put("departure_date", departureDate);
        mapSearch.put("return_date", returnDate);
        mapSearch.put("adult_count", numAdult);
        mapSearch.put("child_count", numChildren);
        mapSearch.put("museums", museums);
        mapSearch.put("art", art);
        mapSearch.put("nature", nature);
        mapSearch.put("shopping", shopping);
        mapSearch.put("night_life", nightLife);
        
        Search search = searchBean.createSearch(mapSearch);
        ArrayList<Hotel> hotels = new ArrayList<Hotel>();
        int num_people = Integer.parseInt(numAdult) + Integer.parseInt(numChildren);
        try{
            hotels = amadeusAPIBean.getHotels(latitude, longitude, num_people, departureDate, returnDate);
        //System.out.print(jsonFlight);
        } catch (Exception ex) {
            System.out.println("sono ne catch");
            //Logger.getLogger(SearchServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.getSession().setAttribute("hotels", hotels);
        request.getSession().setAttribute("search", search);

        if((hotels != null) & !hotels.isEmpty()){
            request.getRequestDispatcher("hotelList.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("Error.html").forward(request, response); 
        }

    }

    private void goTripHotel(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Search search = (Search) request.getSession().getAttribute("search");
        ArrayList<Place> bestPlaces = googlePlacesBean.getInterestingPlaces(search);

        long departureTime = search.getDepartureDate().getTime();
        long returnTime = search.getReturnDate().getTime();
        long timeTrip = returnTime - departureTime;
        int tripDays = ((int)timeTrip/86400000) + 1;
          
        String action = request.getParameter("act");
        String hotelId = request.getParameter("list_id_choosed");
        List<Hotel> hotels = (List<Hotel>) request.getSession().getAttribute("hotels");
        Hotel selectedHotel = null;
        
        if(action.equals("choose") && hotelId != null) {
            int id = Integer.parseInt(hotelId);
            for(Hotel hotel : hotels) {
                if(id == hotel.getList_id()) {
                    selectedHotel = hotel;
                    break;
                }    
            }
        }
        
        Trip trip = tripBean.buildTrip(bestPlaces, tripDays, selectedHotel);
        trip.setSearch(search);
        trip.setHotel(selectedHotel);
        /*Add the owner of the trip here*/

        request.getSession().setAttribute("trip", trip);
        
        request.getRequestDispatcher("tripPages.jsp").forward(request, response);
    }

}
