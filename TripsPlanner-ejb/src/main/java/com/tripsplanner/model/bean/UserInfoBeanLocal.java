/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.model.bean;

import com.tripsplanner.model.entity.User;
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
 * UserInfo bean local interface
 */

@Local
public interface UserInfoBeanLocal {

    /**
     * modifies the specified user changing his information in the database with the new ones
     * @param olduser the user to be changed 
     * @param newName the new name
     * @param newSurname the new surname
     * @param newAge the new age
     * @param newSex the new sex
     * @return string that can have two value "success" or "New data can't be the same as the old ones."
     */
    public String modifyUser(User olduser, String newName, String newSurname, String newAge, String newSex);
    
}
