/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.model.entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Authors: Giovanni Bonetta, Riccardo Renzulli, Gabriele Sartor<br>
 * Università degli Studi di Torino<br>
 * Department of Computer Science<br>
 * Sviluppo Software per Componenti e Servizi Web<br>
 * Date: May 2018<br><br>
 * <p/>
 * giovanni.bonetta@edu.unito.it<br>
 * riccardo.renzulli@edu.unito.it<br>
 * gabriele.sartor@edu.unito.it<br><br>
 */

@Entity
public class Search implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String departureCity;
    
    private String destinationCity;

    private Date departureDate;

    private Date returnDate;

    private int numAdult;

    private int numChildren; //declared for future works
    /*Preferences*/

    private boolean museums;

    private boolean art;

    private boolean nature;

    private boolean nightLife;

    private boolean shopping;
    
    public Search() {}
    
    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getNumAdult() {
        return numAdult;
    }

    public void setNumAdult(int numAdult) {
        this.numAdult = numAdult;
    }

    public int getNumChildren() {
        return numChildren;
    }

    public void setNumChildren(int numChildren) {
        this.numChildren = numChildren;
    }

    public boolean isMuseums() {
        return museums;
    }

    public void setMuseums(boolean museums) {
        this.museums = museums;
    }

    public boolean isArt() {
        return art;
    }

    public void setArt(boolean art) {
        this.art = art;
    }

    public boolean isNature() {
        return nature;
    }

    public void setNature(boolean nature) {
        this.nature = nature;
    }

    public boolean isNightLife() {
        return nightLife;
    }

    public void setNightLife(boolean nightLife) {
        this.nightLife = nightLife;
    }

    public boolean isShopping() {
        return shopping;
    }

    public void setShopping(boolean shopping) {
        this.shopping = shopping;
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Search)) {
            return false;
        }
        Search other = (Search) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tripsplanner.model.entity.Search[ id=" + id + " ]";
    }
    
}
