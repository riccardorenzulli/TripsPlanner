/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.model.bean;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.servlet.ServletContext;

/**
 *
 * @author giovannibonetta
 */
@Stateless
@LocalBean
public class ApiKeysBean {
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void findKeysFromCSV(ServletContext ctx) {
        InputStream csvFile = ctx.getResourceAsStream("/WEB-INF/keys.csv");
        String line = "";
        String cvsSplitBy = ",";
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] api = line.split(cvsSplitBy);
                String apiProvider = api[0];
                String key = api[1];
                ctx.setAttribute(apiProvider, key);
            }
            
            ctx.setAttribute("keysPresent", "True");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
