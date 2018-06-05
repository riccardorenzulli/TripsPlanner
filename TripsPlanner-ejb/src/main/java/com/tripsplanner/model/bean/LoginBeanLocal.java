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
 * <p/>
 * giovanni.bonetta@edu.unito.it<br>
 * riccardo.renzulli@edu.unito.it<br>
 * gabriele.sartor@edu.unito.it<br><br>
 */

@Local
public interface LoginBeanLocal {
    
    User validateFacebookUser(String token, boolean create) throws MalformedURLException, IOException;

    User validateGoogleUser(HashMap<String, String> mapUser);
    
}
