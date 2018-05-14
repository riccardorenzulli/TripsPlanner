/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.servlet;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author the-silent-fox
 */
public class SearchServlet extends HttpServlet {

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

    private void goSearch(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        
        HashMap<String, String> mapSearch = new HashMap<String, String>();
        
        String departureCity = request.getParameter("departure_city");
        String destinationCity = request.getParameter("destination_city");
        String departureDate = request.getParameter("departure_date");
        String returnDate = request.getParameter("return_date");
        String numAdult = request.getParameter("adult_count");
        String numChildren = request.getParameter("child_count");
        String museums = request.getParameter("museums");
        
        mapSearch.put(departureCity, "departure_city");
        mapSearch.put(destinationCity, "destination_city");
        
        System.out.print("Departure: " + departureCity + "\nDestination: " + destinationCity);
        System.out.print("Departure date: " + departureDate + "\nDestination date: " + returnDate);
        System.out.print("Adult: " + numAdult + "\nChildren: " + numChildren);
        System.out.print("Museums checkbox: " + museums);
    }

}
