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
 * giovanni.bonetta@edu.unito.it<br>
 * riccardo.renzulli@edu.unito.it<br>
 * gabriele.sartor@edu.unito.it<br><br>
 * 
 * enetity related to the search informations
 */

@Entity
public class Search implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /**
     * database id for the Search
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    /**
     * the departure city
     */
    private String departureCity;
    
    /**
     * the destination city
     */
    private String destinationCity;

    /**
     * the departure date
     */
    private Date departureDate;

    /**
     * the return date
     */
    private Date returnDate;

    /**
     * the number of traveling adults
     */
    private Integer numAdult;

    /**
     * the number of traveling chidrens
     */
    private Integer numChildren; //declared for future works
    /*Preferences*/

    /**
     * if museums are preferred
     */
    private Boolean museums;

    /**
     * if art is preferred
     */
    private Boolean art;

    /**
     * if nature is preferred
     */
    private Boolean nature;

    /**
     * if nightlife is preferred
     */
    private Boolean nightLife;

    /**
     * if shopping is preferred
     */
    private Boolean shopping;
    
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

    public Integer getNumAdult() {
        return numAdult;
    }

    public void setNumAdult(Integer numAdult) {
        this.numAdult = numAdult;
    }

    public Integer getNumChildren() {
        return numChildren;
    }

    public void setNumChildren(Integer numChildren) {
        this.numChildren = numChildren;
    }

    public Boolean isMuseums() {
        return museums;
    }

    public void setMuseums(Boolean museums) {
        this.museums = museums;
    }

    public Boolean isArt() {
        return art;
    }

    public void setArt(Boolean art) {
        this.art = art;
    }

    public Boolean isNature() {
        return nature;
    }

    public void setNature(Boolean nature) {
        this.nature = nature;
    }

    public Boolean isNightLife() {
        return nightLife;
    }

    public void setNightLife(Boolean nightLife) {
        this.nightLife = nightLife;
    }

    public Boolean isShopping() {
        return shopping;
    }

    public void setShopping(Boolean shopping) {
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
        Integer hash = 0;
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
