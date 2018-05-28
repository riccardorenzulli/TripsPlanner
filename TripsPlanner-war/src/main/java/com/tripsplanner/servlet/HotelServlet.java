/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.servlet;

import com.tripsplanner.model.entity.Hotel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author giovannibonetta
 */
public class HotelServlet extends HttpServlet {

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
            case "tripHotel":
                goHotelTrip(request, response);
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

    private void goHotelTrip(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Hotel> hotels = (ArrayList<Hotel>) request.getSession().getAttribute("hotels");
        String act = request.getParameter("act");
        int id = -1;
                
        System.out.println("numero"+request.getParameter("list_id_choosed"));
        
        if (act.equals("choose")){
            String list_id = request.getParameter("list_id_choosed");
            System.out.println("sono in choose");
            id = Integer.parseInt(list_id);
            request.setAttribute("hotel", hotels.get(id));
            request.setAttribute("action", "tripHotel");
        }else{
            System.out.println("sono in no choose");
            request.setAttribute("hotel", null);
            request.setAttribute("action", "tripNoHotel");
        }
        System.out.println("sono arrivato alla forward alla search, l'hotel "+id+"action"+request.getAttribute("action"));
        request.getRequestDispatcher("/SearchServlet").forward(request, response);
    }

}
