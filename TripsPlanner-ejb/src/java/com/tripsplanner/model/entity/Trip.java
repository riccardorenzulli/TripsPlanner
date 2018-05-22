/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
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
public class Trip implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "owner")
    private User owner;
    @Column(name = "collaborators")
    private ArrayList<User> collaborators;
    @Column(name = "itineraries")
    private ArrayList<DayItinerary> itineraries;
    @Column(name = "search")
    private Search search;

    public Trip() {
        this.owner = null;
        this.collaborators = null;
        this.itineraries = null;
        this.search = null;
    }
    
    public Trip(User owner, ArrayList<User> collaborators, ArrayList<DayItinerary> itineraries, Search search) {
        this.owner = owner;
        this.collaborators = collaborators;
        this.itineraries = itineraries;
        this.search = search;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public ArrayList<User> getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(ArrayList<User> collaborators) {
        this.collaborators = collaborators;
    }

    public ArrayList<DayItinerary> getItineraries() {
        return itineraries;
    }

    public void setItineraries(ArrayList<DayItinerary> itineraries) {
        this.itineraries = itineraries;
    }

    public Search getSearch() {
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
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
        if (!(object instanceof Trip)) {
            return false;
        }
        Trip other = (Trip) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tripsplanner.model.entity.Trip[ id=" + id + " ]";
    }
    
}
