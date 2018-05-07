/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.giocompany.managers;

import com.giocompany.entities.User;
import javax.ejb.Local;

/**
 *
 * @author giovannibonetta
 */
@Local
public interface RegistrationManagerLocal {
    
    public void createUser(User user);
    
    public void findAllUsers();
    
}
