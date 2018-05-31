/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "Trip")
@XmlRootElement
@NamedQueries({
@NamedQuery(name = "Trip.findByOwner", query = "SELECT t FROM Trip t WHERE t.owner = :owner")})
public class Trip implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    private User owner;
    
    @ManyToMany
    @JoinTable(name="trip-collab",
            joinColumns={@JoinColumn(name="trip-id", referencedColumnName = "id")},
            inverseJoinColumns={@JoinColumn(name="collab-id", referencedColumnName = "id")}
    )
    private List<User> collaborators = new ArrayList<>();
    
    @OneToMany(mappedBy="trip", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<DayItinerary> itineraries;
    
    @OneToOne
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

    public List<User> getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(ArrayList<User> collaborators) {
        this.collaborators = collaborators;
    }

    public List<DayItinerary> getItineraries() {
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
        return "Trip{" + "itineraries=" + itineraries + '}';
    }


    
    /*Return the places to be visited the day specified by the parameter*/
    public List<Place> getDayPlaces(int day) {
        if(day > this.itineraries.size() || day < 0)
            new IllegalArgumentException("The trip is not that long!");
        DayItinerary dayItinerary = this.itineraries.get(day);
        List<Place> result = new ArrayList();
        for(Route route : dayItinerary.getLegs()) {
            result.add(route.getDeparturePlace());
        }
        /*Add the last place*/
        int lastLeg = dayItinerary.getLegs().size()-1;
        result.add(dayItinerary.getLegs().get(lastLeg).getArrivalPlace());
        return result;
    }
    
}
