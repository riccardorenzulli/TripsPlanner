/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.model.facade;

import com.tripsplanner.model.entity.Search;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author the-silent-fox
 */
@Local
public interface SearchFacadeLocal {

    void create(Search search);

    void edit(Search search);

    void remove(Search search);

    Search find(Object id);

    List<Search> findAll();

    List<Search> findRange(int[] range);

    int count();
    
}
