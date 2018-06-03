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
 *
 * @author riccardo
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
