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
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author giovannibonetta
 */
@Entity
public class Hotel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "cityCode")
    private String cityCode;
    
    @Column(name = "roomType")
    private String roomType;
    
    @Column(name = "roomDescription")
    private String roomDescription;
    
    @Column(name = "currency")
    private String currency;
    
    @Column(name = "total")
    private float total;   
    
    @Column(name = "available")
    private boolean available;
    
    @Column(name = "latitude")
    private float latitude;
    
    @Column(name = "longitude")
    private float longitude;

    public Hotel(String name, String cityCode, String roomType, String roomDescription, String currency, float total, boolean avaiable, float latitude, float longitude) {
        this.name = name;
        this.cityCode = cityCode;
        this.roomType = roomType;
        this.roomDescription = roomDescription;
        this.currency = currency;
        this.total = total;
        this.available = available;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public boolean getAvaiable() {
        return available;
    }

    public void setAvaiable(boolean available) {
        this.available = available;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
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
        if (!(object instanceof Hotel)) {
            return false;
        }
        Hotel other = (Hotel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Hotel{" + "id=" + id + ", name=" + name + ", cityCode=" + cityCode + ", roomType=" + roomType + ", roomDescription=" + roomDescription + ", currency=" + currency + ", total=" + total + ", available=" + available + ", latitude=" + latitude + ", longitude=" + longitude + '}';
    }
    
    public static Hotel fromJsonToHotel(JSONObject h) {
        
        boolean available = h.getBoolean("available");
        String name = h.getJSONObject("hotel").getString("name");
        String cityCode = h.getJSONObject("hotel").getString("cityCode");
        float latitude = h.getJSONObject("hotel").getFloat("latitude");
        float longitude = h.getJSONObject("hotel").getFloat("longitude");
        
        JSONArray offers = h.getJSONArray("offers");
        JSONObject offer = offers.getJSONObject(0);
        
        String roomType = "no description for this room";
        try{
            roomType = offer.getJSONObject("room").getJSONObject("typeEstimated").getString("category");
        }catch(Exception e){}
        
        String roomDescription = offer.getJSONObject("room").getJSONObject("description").getString("text");
        String currency = offer.getJSONObject("price").getString("currency");
        float total = offer.getJSONObject("price").getFloat("total");
        
        Hotel hotel = new Hotel(name, cityCode, roomType, roomDescription, currency, total, available, latitude, longitude);
        
        return hotel;
    }
    

}