package com.tripsplanner.model.bean;

import com.tripsplanner.model.entity.User;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import javax.ejb.Local;

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
 * local interface for login bean
 */


@Local
public interface LoginBeanLocal {
    
    /**
     * validate the facebook user
     * 
     * @param token facebook user token
     * @param create 
     * @return validated user
     * @throws MalformedURLException
     * @throws IOException 
     */
    User validateFacebookUser(String token, boolean create) throws MalformedURLException, IOException;

    /**
     * validate the Google user
     * 
     * @param mapUser map with user informations
     * @return validated user
     */
    User validateGoogleUser(HashMap<String, String> mapUser);
    
}
