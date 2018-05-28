/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.model.bean;

import com.tripsplanner.model.entity.User;
import javax.ejb.Local;

/**
 *
 * @author riccardo
 */
@Local
public interface UserInfoBeanLocal {

    public String modifyUser(User olduser, String newName, String newSurname, String newAge, String newSex);
    
}
