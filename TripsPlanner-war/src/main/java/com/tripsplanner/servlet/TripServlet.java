/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.servlet;

import com.tripsplanner.model.bean.TripBeanLocal;
import com.tripsplanner.model.entity.Trip;
import com.tripsplanner.model.entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author the-silent-fox
 */
public class TripServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        String action = request.getParameter("action");
        switch(action == null ? "" : action) {
            case "save-trip":
                if (request.getSession().getAttribute("user") != null) saveTrip(request, response);
                break;
            case "tripsPage":
                loadTrips(request, response);
                break;
            case "delete-trip":
                removeTrip(request, response);
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

    private void saveTrip(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Trip myTrip = (Trip) request.getSession().getAttribute("trip");
        User owner = (User) request.getSession().getAttribute("user");
        myTrip.setOwner(owner);
        //System.out.println(myTrip.toString());
        tripBean.saveTrip(myTrip);
        
        List<Trip> trips = tripBean.getAllTripByOwner(owner);
//       for (Trip t : trips){
//            System.out.println("un trip "+t.toString());
//       }
        request.setAttribute("trips", trips);
        request.getRequestDispatcher("myTrips.jsp").forward(request, response);
    }

    private void loadTrips(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User owner = (User) request.getSession().getAttribute("user");
        if(owner != null){
            List<Trip> trips = tripBean.getAllTripByOwner(owner);
            request.setAttribute("trips", trips);
            request.getRequestDispatcher("myTrips.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    private void removeTrip(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User owner = (User) request.getSession().getAttribute("user");
        String stringId = request.getParameter("id");
        long id = Long.parseLong(stringId);
        if(owner != null){
            List<Trip> trips = tripBean.getAllTripByOwner(owner);
            Trip tripToRemove = null;
            for(Trip trip : trips) {
                if(id == trip.getId()) {
                    tripToRemove = trip;
                    break;
                }
            }
            tripBean.removeTrip(tripToRemove);
            trips.remove(tripToRemove);
            request.setAttribute("trips", trips);
            request.getRequestDispatcher("myTrips.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("myTrips.jsp").forward(request, response);
        }
    }

}
