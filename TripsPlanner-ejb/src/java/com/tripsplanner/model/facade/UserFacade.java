/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.model.facade;

import com.tripsplanner.model.entity.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author giovannibonetta
 */
@Stateless
public class UserFacade extends AbstractFacade<User> implements UserFacadeLocal {

    @PersistenceContext(unitName = "TripsPlanner-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }
    
    public User findUserByEmail(String email) {
        List<User> results = em.createNamedQuery("User.findByEmail")
                .setParameter("email", email)
                .setMaxResults(10)
                .getResultList();
        if (results.size() > 1) {
            throw new IllegalStateException("The email address '" + email + "' is used by more than one user!");
        }
        return results.isEmpty() ? null : results.get(0);
    }
    
}
