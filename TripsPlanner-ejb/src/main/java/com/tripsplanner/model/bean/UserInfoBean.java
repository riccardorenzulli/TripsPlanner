/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.model.bean;

import com.tripsplanner.model.entity.User;
import com.tripsplanner.model.facade.UserFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author riccardo
 */
@Stateless
public class UserInfoBean implements UserInfoBeanLocal {

    @EJB
    private UserFacadeLocal userFacade;

    @Override
    public void modifyUser(User oldUser, String newName, String newSurname, String newAge, String newSex) {
        oldUser.setName(newName);
        oldUser.setSurname(newSurname);
        oldUser.setAge(Integer.parseInt(newAge));
        oldUser.setSex(newSex);
        
        userFacade.edit(oldUser);
    }
    
    
}
