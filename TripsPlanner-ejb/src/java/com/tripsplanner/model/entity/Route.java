/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.model.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author riccardo
 */
@Entity
public class Route implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "departurePlace")
    private Place departurePlace;
    @Column(name = "arrivalPlace")
    private Place arrivalPlace;
    
    @Column(name = "distanceText")
    private String distanceText;
    @Column(name = "distanceValue")   
    private long distanceValue;
    
    @Column(name = "durationText") 
    private String durationText;
    @Column(name = "durationValue")
    private long durationValue;
    
    @Column(name = "travelMode")
    private String travelMode;
    
    @Column(name = "fareText")
    private String fareText;
    @Column(name = "fareValue")
    private double fareValue;
    
    @Column(name = "query")
    private String query;
    
    @Column(name = "departureTime")
    private long departureTime;
    @Column(name = "arrivalTime")
    private long arrivalTime;

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
        if (!(object instanceof Route)) {
            return false;
        }
        Route other = (Route) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tripsplanner.model.entity.Route[ id=" + id + " ]";
    }
    
}
