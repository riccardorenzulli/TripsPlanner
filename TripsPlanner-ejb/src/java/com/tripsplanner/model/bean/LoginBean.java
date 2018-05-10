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
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.json.JSONObject;

/**
 *
 * @author giovannibonetta
 */
@Stateless
public class LoginBean implements LoginBeanLocal {

    @EJB
    private UserFacadeLocal userFacade;

    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public User validateFacebookUser(String token, boolean create) throws MalformedURLException, IOException {
        JSONObject userJson = getFacebookUserJson(token);
        
        User user = userFacade.findUserByEmail(userJson.getString("email"));
        
        if (user == null && create) {
            user = new User();
            user.setEmail(userJson.getString("email"));
            user.setName(userJson.getString("name"));
            user.setImgURL(userJson.getJSONObject("picture").getJSONObject("data").getString("url"));

            userFacade.create(user);
        }
        
        return user;
    }
    
    private JSONObject getFacebookUserJson(String token)
            throws MalformedURLException, IOException {
        URL validationUrl = new URL("https://graph.facebook.com/me?fields=id,name,email,picture&access_token=" + token);
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
    
}
