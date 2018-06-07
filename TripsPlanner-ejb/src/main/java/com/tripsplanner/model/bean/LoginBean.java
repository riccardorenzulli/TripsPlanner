/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.model.bean;

import com.tripsplanner.model.entity.User;
import com.tripsplanner.model.facade.UserFacadeLocal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import javax.ejb.EJB;
import javax.ejb.Stateless;
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
 * bean with the business logic related to login
 */

@Stateless
public class LoginBean implements LoginBeanLocal {

    @EJB
    private UserFacadeLocal userFacade;

    
    public User validateFacebookUser(String token, boolean create) throws MalformedURLException, IOException {
        System.out.print("validateFbUser");
        
        JSONObject userJson = getFacebookUserJson(token);
        
        System.out.print(userJson.toString());
        
        User user = userFacade.findUserByEmail(userJson.getString("email"));
        
        if (user == null && create) {
            user = new User();
            user.setEmail(userJson.getString("email"));
            user.setName(userJson.getString("name"));
            user.setImgURL(userJson.getJSONObject("picture").getJSONObject("data").getString("url"));
            System.out.print(user.getImgURL());
            userFacade.create(user);
        }
        
        return user;
    }
    
    private JSONObject getFacebookUserJson(String token)
            throws MalformedURLException, IOException {
        
        URL validationUrl = new URL("http://graph.facebook.com/me?fields=name,email&access_token=" + token);
        HttpURLConnection conn = (HttpURLConnection) validationUrl.openConnection();

        StringBuilder b;
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(conn.getInputStream()))) {
            String inputLine;
            b = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                b.append(inputLine).append("\n");
            }
        }
        String graph = b.toString();
        JSONObject jsonOut = new JSONObject(graph);
        return jsonOut.has("error") ? null : jsonOut;
    }

    /**
     * looks for a user in the database with the same email of the user provided
     * if the user is already present it is returned, hoterwise is created
     * 
     * @param mapUser map with user informations
     * @return the validated user
     */
    public User validateGoogleUser(HashMap<String, String> mapUser) {

        User user = userFacade.findUserByEmail(mapUser.get("email"));

        if (user == null) {
            user = new User();
            user.setEmail(mapUser.get("email"));
            user.setName(mapUser.get("name"));
            user.setSurname(mapUser.get("surname"));
            user.setImgURL(mapUser.get("imgURL"));
            user.setGoogleID(mapUser.get("id"));

            userFacade.create(user);
        }
        
        return user;
    }
    
}
