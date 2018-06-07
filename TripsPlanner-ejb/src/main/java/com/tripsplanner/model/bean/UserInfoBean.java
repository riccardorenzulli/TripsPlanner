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
 * Authors: Giovanni Bonetta, Riccardo Renzulli, Gabriele Sartor<br>
 * Università degli Studi di Torino<br>
 * Department of Computer Science<br>
 * Sviluppo Software per Componenti e Servizi Web<br>
 * Date: May 2018<br><br>
 * giovanni.bonetta@edu.unito.it<br>
 * riccardo.renzulli@edu.unito.it<br>
 * gabriele.sartor@edu.unito.it<br><br>
 * 
 * bean containing the business logic for the User
 */
@Stateless
public class UserInfoBean implements UserInfoBeanLocal {

    @EJB
    private UserFacadeLocal userFacade;

    /**
     * modifies the specified user changing his information in the database with the new ones
     * @param oldUser the user to be changed 
     * @param newName the new name
     * @param newSurname the new surname
     * @param newAge the new age
     * @param newSex the new sex
     * @return string that can have two value "success" or "New data can't be the same as the old ones."
     */
    @Override
    public String modifyUser(User oldUser, String newName, String newSurname, String newAge, String newSex) {
        
        boolean isOld = newName.equals(oldUser.getName()) && newSurname.equals(oldUser.getSurname()) 
                && newAge.equals((oldUser.getAge()).toString()) && newSex.equals(oldUser.getSex()); 
        
        if (!isOld) {
            
            String res = checkNewInfo(newName, newSurname, newAge, newSex);
            
            if (!(res.equals("success"))) return res;
            
            oldUser.setName(newName);
            oldUser.setSurname(newSurname);
            oldUser.setAge(Integer.parseInt(newAge));
            oldUser.setSex(newSex);
        
            userFacade.edit(oldUser);
            return res;
        }
        
        return "New data can't be the same as the old ones.";
    }

    private String checkNewInfo(String name, String surname, String age, String sex) {
        String result;
        if(name == "") {
            result = "Name field is empty! \n Please insert your name.";
            return result;
        }
  
        else if(!checkExpressionReg(name, "^[a-zA-Z]{1,30}$")) {
            result = "Name field is incorrect! \n Please insert a valid name.";
            return result;
        }
    
        if(surname == "") {
            result = "Surname field is empty! \n Please insert your surname.";
            return result;
        }

        else if(!checkExpressionReg(surname, "^[a-zA-Z]{1,30}$")) {
            result = "Surname field is incorrect! \n Please insert a valid surname.";
            return result;
        }

        if(age == "") {
            result = "Age field is empty! \n Please insert your age.";
            return result;
        }

        else if(!checkExpressionReg(age, "^[0-9]{2,3}$")) {
            result = "Age field is incorrect! \n Please insert a valid age.";
            return result;
        }

        if(sex == "") {
            result = "Sex field is empty! \n Please insert your sex.";
            return result;
        }

        else if(!checkExpressionReg(sex, "^(Male|Female|Other|male|female|other)$")) {
            result = "Sex field is incorrect! \n Please insert a valid sex.";
            return result;
        }
        
        else return "success";
        
    }

    private boolean checkExpressionReg(String s, String expr) {
        return s.matches(expr);
    }
    
}
