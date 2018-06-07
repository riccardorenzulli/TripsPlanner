/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.model.bean;

import com.tripsplanner.model.entity.Memory;
import com.tripsplanner.model.entity.Place;
import com.tripsplanner.model.entity.User;
import java.io.InputStream;
import java.text.ParseException;
import javax.ejb.Local;
import javax.servlet.http.Part;

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
 * local interface of memory bean
 */

@Local
public interface MemoryBeanLocal {

    /**
     * upload a memory
     * 
     * @param description memory description 
     * @param filePart FilePart of the image
     * @param fileContent the media to be uploaded
     * @param user the memory owner
     * @return the saved Memory 
     * @throws ParseException parse exception
     */
    public Memory uploadMemory(String description, Part filePart, InputStream fileContent, User user) throws ParseException;

    /**
     * remove the momory from the database
     * @param memory the memory to be removed
     */
    public void removeMemory(Memory memory);
    
}
