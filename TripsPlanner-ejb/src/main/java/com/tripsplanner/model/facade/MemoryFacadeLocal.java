/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.model.facade;

import com.tripsplanner.model.entity.Memory;
import java.util.List;
import javax.ejb.Local;

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
 * expose memory CRUD operations
 */
@Local
public interface MemoryFacadeLocal {

    void create(Memory memory);

    void edit(Memory memory);

    void remove(Memory memory);

    Memory find(Object id);

    List<Memory> findAll();

    List<Memory> findRange(int[] range);

    int count();
    
}
