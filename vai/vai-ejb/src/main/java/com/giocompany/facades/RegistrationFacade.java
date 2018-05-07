/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.giocompany.facades;

import com.giocompany.entities.User;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;


/**
 *
 * @author giovannibonetta
 */
@Stateless
public class RegistrationFacade extends AbstractFacade<User> implements RegistrationFacadeLocal {
    
//    @Resource(name = "com.giocompany_vai-ejb_ejb_1.0PU")
      @PersistenceContext(unitName = "demo_pu")
      private EntityManagerFactory emf;

    @Override
    protected EntityManager getEntityManager() {
        System.out.println("SONO DENTRO IL GETENTITYMANAGER DEL REGFACADE");
        return emf.createEntityManager();
    }

    public RegistrationFacade() {
        super(User.class);
    }
    
    
}
