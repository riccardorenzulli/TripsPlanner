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
public class Route implements Serializable {

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
    private Long distanceValue;
    @Column(name = "durationText") 
    private String durationText;
    @Column(name = "durationValue")
    private Long durationValue;
    @Column(name = "travelMode")
    private String travelMode;
    @Column(name = "fareText")
    private String fareText;
    @Column(name = "fareValue")
    private Double fareValue;
    @Column(name = "query")
    private String query;
    @Column(name = "departureTimeText")
    private String departureTimeText;
    @Column(name = "departureTimeValue")
    private Long departureTimeValue;
    @Column(name = "arrivalTimeText")
    private String arrivalTimeText;
    @Column(name = "arrivalTimeValue")
    private Long arrivalTimeValue;

    public Route() {
        this.departurePlace = null;
        this.arrivalPlace = null;
        this.distanceText = null;
        this.distanceValue = null;
        this.durationText = null;
        this.durationValue = null;
        this.travelMode = null;
        this.fareText = null;
        this.fareValue = null;
        this.query = null;
        this.departureTimeText = null;
        this.departureTimeValue = null;
        this.arrivalTimeText = null;
        this.arrivalTimeValue = null;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Place getDeparturePlace() {
        return departurePlace;
    }

    public void setDeparturePlace(Place departurePlace) {
        this.departurePlace = departurePlace;
    }

    public Place getArrivalPlace() {
        return arrivalPlace;
    }

    public void setArrivalPlace(Place arrivalPlace) {
        this.arrivalPlace = arrivalPlace;
    }

    public String getDistanceText() {
        return distanceText;
    }

    public void setDistanceText(String distanceText) {
        this.distanceText = distanceText;
    }

    public long getDistanceValue() {
        return distanceValue;
    }

    public void setDistanceValue(long distanceValue) {
        this.distanceValue = distanceValue;
    }

    public String getDurationText() {
        return durationText;
    }

    public void setDurationText(String durationText) {
        this.durationText = durationText;
    }

    public long getDurationValue() {
        return durationValue;
    }

    public void setDurationValue(long durationValue) {
        this.durationValue = durationValue;
    }

    public String getTravelMode() {
        return travelMode;
    }

    public void setTravelMode(String travelMode) {
        this.travelMode = travelMode;
    }

    public String getFareText() {
        return fareText;
    }

    public void setFareText(String fareText) {
        this.fareText = fareText;
    }

    public double getFareValue() {
        return fareValue;
    }

    public void setFareValue(double fareValue) {
        this.fareValue = fareValue;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getDepartureTimeText() {
        return departureTimeText;
    }

    public void setDepartureTimeText(String departureTimeText) {
        this.departureTimeText = departureTimeText;
    }

    public long getDepartureTimeValue() {
        return departureTimeValue;
    }

    public void setDepartureTimeValue(long departureTimeValue) {
        this.departureTimeValue = departureTimeValue;
    }

    public String getArrivalTimeText() {
        return arrivalTimeText;
    }

    public void setArrivalTimeText(String arrivalTimeText) {
        this.arrivalTimeText = arrivalTimeText;
    }

    public long getArrivalTimeValue() {
        return arrivalTimeValue;
    }

    public void setArrivalTimeValue(long arrivalTimeTextValue) {
        this.arrivalTimeValue = arrivalTimeTextValue;
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
        return "Route{" + 
                      "\n id=" + id + 
                      "\n departurePlace=" + departurePlace.getName() + 
                      "\n arrivalPlace=" + arrivalPlace.getName() + 
                      "\n distanceText=" + distanceText + 
                      "\n distanceValue=" + distanceValue + 
                      "\n durationText=" + durationText + 
                      "\n durationValue=" + durationValue + 
                      "\n travelMode=" + travelMode + 
                      "\n fareText=" + fareText + 
                      "\n, fareValue=" + fareValue + 
                      "\n query=" + query + 
                      "\n departureTimeText=" + departureTimeText + 
                      "\n departureTimeValue=" + departureTimeValue + 
                      "\n arrivalTimeText=" + arrivalTimeText + 
                      "\n arrivalTimeValue=" + arrivalTimeValue + '}';
    }
    
    public String getInfo() {
        
        return ""+this.durationText+" by "+this.travelMode;
    }
    
}
