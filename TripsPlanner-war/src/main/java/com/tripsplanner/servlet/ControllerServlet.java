/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.servlet;

import com.tripsplanner.model.bean.ApiKeysBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

public class ControllerServlet extends HttpServlet {

    @EJB
    private ApiKeysBean apiKaysBean;
    
    
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
        
        PrintWriter out = response.getWriter();
        ServletContext ctx = getServletContext();
        String action = request.getParameter("action");
        
        // control for api keys in session
        apiKaysBean.findKeysFromCSV(ctx);
        
        if (action == null) {
            RequestDispatcher rd = ctx.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }
        
        else if (action.equalsIgnoreCase("login") || action.equalsIgnoreCase("login-f") || action.equalsIgnoreCase("login-g") || action.equalsIgnoreCase("logout")) {
            RequestDispatcher rd = ctx.getRequestDispatcher("/LoginServlet");
            rd.forward(request, response);
        }
        
        else if (action.equalsIgnoreCase("search")) {
            RequestDispatcher rd = ctx.getRequestDispatcher("/SearchServlet");
            rd.forward(request, response);
        }
        

        else if(action.equalsIgnoreCase("tripHotel")) {
            RequestDispatcher rd = ctx.getRequestDispatcher("/SearchServlet");

        else if (action.equalsIgnoreCase("memoryUpload")) {
            RequestDispatcher rd = ctx.getRequestDispatcher("/MemoryServlet");
            rd.forward(request, response);
        }
        
        else if (action.equalsIgnoreCase("user-info")) {
            RequestDispatcher rd = ctx.getRequestDispatcher("/user-profile.jsp");
            rd.forward(request, response);
        }
        
        else if (action.equalsIgnoreCase("modify-user-info")) {
            RequestDispatcher rd = ctx.getRequestDispatcher("/UserServlet");
            rd.forward(request, response);
        }
        
        else if (action.equalsIgnoreCase("contacts")) {
            RequestDispatcher rd = ctx.getRequestDispatcher("/contact-us.jsp");
            rd.forward(request, response);
        }
        
        else {
            RequestDispatcher rd = ctx.getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
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

}
