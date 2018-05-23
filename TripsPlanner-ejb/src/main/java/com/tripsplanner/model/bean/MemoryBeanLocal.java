/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.model.bean;

import com.tripsplanner.model.entity.User;
import java.io.InputStream;
import java.text.ParseException;
import javax.ejb.Local;
import javax.servlet.http.Part;

/**
 *
 * @author riccardo
 */
@Local
public interface MemoryBeanLocal {

    public void uploadMemory(String description, Part filePart, String fileName, InputStream fileContent, User user) throws ParseException;
    
}
