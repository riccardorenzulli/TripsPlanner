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
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;


/**
 *
 * @author giovannibonetta
 */
@Stateless
public class UserFacade extends AbstractFacade<User> implements UserFacadeLocal {
    
    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }
    
//    @PostConstruct
//    public void init(){
//        this.em = Persistence.createEntityManagerFactory("demo_pu").createEntityManager();
//    }
    
}
