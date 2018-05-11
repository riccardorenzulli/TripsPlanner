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
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
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
        
        System.out.println("------------JSON--------------");

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
        System.out.println("------------JSON--------------");
        System.out.println(jsonOut);
        return jsonOut.has("error") ? null : jsonOut;
    }

    public User validateGoogleUser(HashMap<String, String> mapUser) {

        User user = userFacade.findUserByEmail(mapUser.get("email"));

        if (user == null) {
            user = new User();
            user.setEmail(mapUser.get("email"));
            user.setName(mapUser.get("name"));
            user.setSurname(mapUser.get("surname"));
            user.setImgURL(mapUser.get("imgURL"));
            user.setGoogleID(mapUser.get("id"));
            
            System.out.print("-----GOOGLE ID:"+user.getGoogleID());
            System.out.print(user.getEmail());
            
            System.out.print(user.getName());
            System.out.print(user.getSurname());
            System.out.print(user.getImgURL());

            userFacade.create(user);
        }
        
        return user;
    }
    
}
