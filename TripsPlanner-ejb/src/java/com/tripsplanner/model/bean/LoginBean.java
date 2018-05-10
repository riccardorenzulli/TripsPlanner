/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.model.bean;

import com.tripsplanner.model.facade.UserFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

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
}
