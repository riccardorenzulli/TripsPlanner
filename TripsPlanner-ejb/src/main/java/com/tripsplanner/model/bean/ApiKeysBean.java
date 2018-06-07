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
import java.util.HashMap;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.servlet.ServletContext;

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
 * bean for load external api keys 
 * 
 */
@Stateless
@LocalBean
public class ApiKeysBean {
    public static HashMap<String, String> keys = new HashMap<String, String>();

    /**
     * loads external api keys and save them in the servlet context
     * 
     * @param ctx the servlet context
     */
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
                keys.put(apiProvider, key);
            }
            
            ctx.setAttribute("keysPresent", "True");
            keys.put("keysPresent", "True");
            

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
