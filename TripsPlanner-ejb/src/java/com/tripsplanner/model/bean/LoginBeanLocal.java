/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.model.bean;

import com.tripsplanner.model.entity.User;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.ejb.Local;

/**
 *
 * @author giovannibonetta
 */
@Local
public interface LoginBeanLocal {
    
    User validateFacebookUser(String token, boolean create) throws MalformedURLException, IOException;
    
}
