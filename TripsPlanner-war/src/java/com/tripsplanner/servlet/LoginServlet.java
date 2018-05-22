/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.servlet;

import com.tripsplanner.model.bean.LoginBeanLocal;
import com.tripsplanner.model.entity.User;
import static com.tripsplanner.util.ServletUtil.domain;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @EJB
    private LoginBeanLocal loginBean;

    
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
        try {
            String action = request.getParameter("action");
            
            switch(action == null ? "" : action) {
                case "login":
                    goLogin(request, response);
                    break;
                case "login-f":
                    goLoginFB(request, response);
                    break;
                case "login-g":
                    goLoginGoogle(request, response);
                    break;
                case "logout":
                    logout(request, response);
                    break;
                    
            }
        } catch (IOException | ServletException e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.html");
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

    private void goLogin(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        
        HttpSession session = request.getSession();

        if (session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
        }
        
        else {
            System.out.println("esiste già un utente in sessione");
        } 
        
    }
    
    private void goLoginFB(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String token = request.getParameter("idtoken");
        
        User user = loginBean.validateFacebookUser(token, true);

         if (session.getAttribute("user") == null) {
             response.sendRedirect("login.jsp");
         }
    }

    private void goLoginGoogle(HttpServletRequest request, HttpServletResponse response) 
    throws IOException, ServletException{        
        HttpSession session = request.getSession();
        
        HashMap<String, String> mapUser = new HashMap<String, String>();
        
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String imgURL = request.getParameter("imgURL");
        String id = request.getParameter("id");
        
        mapUser.put("email", email);
        mapUser.put("name", name);
        mapUser.put("surname", surname);
        mapUser.put("imgURL", imgURL);
        mapUser.put("id", id);
        
        try{
        // create user in db if not present, and return user
        User user = loginBean.validateGoogleUser(mapUser);
        
        
        if (user == null) {
                throw new ServletException("Cant validate user");
            }

        String typeLogin = "google";
        // setup the user in the session
        setupSession(user, typeLogin, request, response);
            
        }catch (ServletException | IOException e) {
            // msg sent in the http request
            request.setAttribute("msg", e.getMessage());
            request.getRequestDispatcher("/admin/500.jsp").forward(request, response);
        }
 
    }

    private void setupSession(User user, String typeLogin, HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException{
        
        // add the user object and logintype to the http session
        request.getSession().setAttribute("user", user);
        request.getSession().setAttribute("typeLogin", typeLogin);
        
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = getSessionUser(request);
        if (user != null) {
            //if(request.getSession()!=null)
            request.getSession().invalidate();
            user = null;
        }
        response.sendRedirect("index.jsp");
    }
    
    private User getSessionUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (User)session.getAttribute("user");
    }

}