/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.model.bean;

import java.util.HashMap;
import javax.ejb.Local;

/**
 *
 * @author the-silent-fox
 */
@Local
public interface SearchBeanLocal {

    public void performSearch(HashMap<String, String> mapSearch);
    
}
