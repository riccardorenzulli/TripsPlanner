/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.giocompany.managers;

import com.giocompany.entities.User;
import com.giocompany.facades.RegistrationFacadeLocal;
import com.giocompany.facades.UserFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 * @author giovannibonetta
 */

@Stateless(mappedName = "RegistrationManager")
//@TransactionManagement(TransactionManagementType.CONTAINER)
public class RegistrationManager implements RegistrationManagerLocal {

    @EJB
    private UserFacadeLocal userFacade;

    
    @Override
    //@TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void createUser(User user) {
        userFacade.create(user);
    }

    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void findAllUsers() {
        List<User> users = userFacade.findAll();
        for (User temp : users){
            System.out.println("user:"+temp.getName());
        }
    }
}
