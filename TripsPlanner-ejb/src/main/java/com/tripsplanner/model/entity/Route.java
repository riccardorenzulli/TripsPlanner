/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.model.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
 * enetity related to the route informations
 */

@Entity
@Table(name = "Route")
@NamedQueries({
@NamedQuery(name = "Route.findSecondPlaceIMG", query = "SELECT t.arrivalPlace.photosUrl FROM Route t WHERE t.dayItinerary.id = :dayItID")
})
public class Route implements Serializable {

    /**
     * database id for the Route
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    /**
     * the parent DayItinerary
     */
    @ManyToOne
    private DayItinerary dayItinerary;

    /**
     * the root starting place
     */
    @ManyToOne
    private Place departurePlace;
    
    /**
     * the route arrival place
     */
    @ManyToOne
    private Place arrivalPlace;
    
    /**
     * the distance between departure and arrival places 
     */
    private String distanceText;
    
    /**
     * the distance between departure and arrival places 
     */
    private Long distanceValue;
    
    /**
     * the rout travel time
     */
    private String durationText;
    
    /**
     * the rout travel time
     */
    private Long durationValue;
    
    /**
     * the route travel mode
     */
    private String travelMode;
    
    /**
     * the route travel fare
     */
    private String fareText;
    
    /**
     * the value for the route travel fare
     */
    private Double fareValue;
    
    /**
     * the query for the Google api service
     */
    private String query;
    
    /**
     * departure time
     */
    private String departureTimeText;
    
    /**
     * departure time
     */
    private Long departureTimeValue;
    
    /**
     * arrival time
     */
    private String arrivalTimeText;
    
    /**
     * arrival time
     */
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
        this.dayItinerary = null;
    }

    public DayItinerary getDayItinerary() {
        return dayItinerary;
    }

    public void setDayItinerary(DayItinerary dayItinerary) {
        this.dayItinerary = dayItinerary;
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

    public Long getDistanceValue() {
        return distanceValue;
    }

    public void setDistanceValue(Long distanceValue) {
        this.distanceValue = distanceValue;
    }

    public String getDurationText() {
        return durationText;
    }

    public void setDurationText(String durationText) {
        this.durationText = durationText;
    }

    public Long getDurationValue() {
        return durationValue;
    }

    public void setDurationValue(Long durationValue) {
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

    public Double getFareValue() {
        return fareValue;
    }

    public void setFareValue(Double fareValue) {
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

    public Long getDepartureTimeValue() {
        return departureTimeValue;
    }

    public void setDepartureTimeValue(Long departureTimeValue) {
        this.departureTimeValue = departureTimeValue;
    }

    public String getArrivalTimeText() {
        return arrivalTimeText;
    }

    public void setArrivalTimeText(String arrivalTimeText) {
        this.arrivalTimeText = arrivalTimeText;
    }

    public Long getArrivalTimeValue() {
        return arrivalTimeValue;
    }

    public void setArrivalTimeValue(Long arrivalTimeTextValue) {
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
    
    public String getMapsDirections() {        
        return "https://www.google.com/maps/dir/?api=1&"
                + "origin="+this.departurePlace.getAddress().replaceAll("[^A-Za-z0-9]", "+")
                + "&destination="+this.arrivalPlace.getAddress().replaceAll("[^A-Za-z0-9]", "+");
    }
    
}
