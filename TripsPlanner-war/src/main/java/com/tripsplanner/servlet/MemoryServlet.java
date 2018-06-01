/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.servlet;

import com.tripsplanner.model.bean.MemoryBeanLocal;
import com.tripsplanner.model.bean.PlaceBeanLocal;
import com.tripsplanner.model.entity.Memory;
import com.tripsplanner.model.entity.Place;
import com.tripsplanner.model.entity.Trip;
import com.tripsplanner.model.entity.User;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

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

@MultipartConfig
public class MemoryServlet extends HttpServlet {

    @EJB
    private PlaceBeanLocal placeBean;

    @EJB
    private MemoryBeanLocal memoryBean;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        ServletContext ctx = getServletContext();
        String action = request.getParameter("action");
        
        response.setContentType("text/html;charset=UTF-8");

        if(action.equalsIgnoreCase("memoryUpload")) {
            
            int day = Integer.getInteger(request.getParameter("day"));
            int indexPlace = Integer.getInteger(request.getParameter("id"));
            User user = getSessionUser(request);
            Trip trip = getSessionTrip(request);
            List<Place> places = (List<Place>) trip.getDayPlaces(day);
            Place place = places.get(indexPlace);
            String description = request.getParameter("description"); // Retrieves <input type="text" name="description">
            Part filePart = request.getPart("memoryIMG"); // Retrieves <input type="file" name="file">
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
            InputStream fileContent = filePart.getInputStream();

            try {
                Memory memory = memoryBean.uploadMemory(description, filePart, fileName, fileContent, user);
                placeBean.updatePlace(memory, place);
                request.getRequestDispatcher("tripPagesFromTrips.jsp").forward(request, response);
                
            } catch (ParseException ex) {
                //rimandare ad una pagina o popup error
                Logger.getLogger(MemoryServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        else {
            RequestDispatcher rd = ctx.getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }
    }
    
    private User getSessionUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (User)session.getAttribute("user");
    }
    
    private Trip getSessionTrip(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (Trip)session.getAttribute("trip");
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

}
