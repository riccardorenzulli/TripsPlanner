/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tripsplanner.model.bean;

import com.tripsplanner.model.entity.Place;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import javax.ejb.Stateless;

/**
 *
 * @author the-silent-fox
 */
@Stateless
public class TripBean implements TripBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public void buildTrip() {
        /*Clustering + shortest path tour*/
        Random rand = new Random();
        List<Place> places = null;
        int daysOfTrip = 3;
        int numberOfPlaces = places.size();
        
        ArrayList<Integer> medoidsIndex = new ArrayList<Integer>();
        /*initializing centroids*/
        for(int i=0; i<daysOfTrip; i++) {
            boolean equalCentroids = true;
            /*create unique centroids*/
            while(equalCentroids) {
                int newIndex = rand.nextInt(daysOfTrip);
                if(!medoidsIndex.contains(newIndex)) { //need to use Integer object?
                    medoidsIndex.add(newIndex);
                    equalCentroids = false;
                }
            }
        }
        
        ArrayList<ArrayList<Integer>> clusters = new ArrayList<ArrayList<Integer>>();
        /*Assign places to the closest medoids*/
        for(int i=0; i<numberOfPlaces; i++) {
            int closestClusterIndex = getClosestCluster(places, medoidsIndex, i);
            clusters.get(closestClusterIndex).add(i); //put the place i in the closest cluster
        }
        /*Recalculate medoids*/
        for(int i=0; i<medoidsIndex.size(); i++) {
            int indexBestMedoid = calculateBestMedoid(places, clusters.get(i), i);
        }
        
    }

    private int getClosestCluster(List<Place> places, ArrayList<Integer> medoidsIndex, int placeIndex) {
        int indexClosestCluster = 0;
        float minDistance = Float.MAX_VALUE;
        for(int i=0; i<medoidsIndex.size(); i++) {
            float distance = getDistance(places.get(placeIndex), places.get(i));
            if(distance < minDistance) {
                minDistance = distance;
                indexClosestCluster = i;
            }
        }
        return indexClosestCluster;
    }

    /*Euclidean distance between two places*/
    private float getDistance(Place place1, Place place2) {
       float latDifference = (float) Math.pow(place1.getLat() - place2.getLat(), 2);
       float lngDifference = (float) Math.pow(place1.getLng() - place2.getLng(), 2);
       return (float) Math.sqrt(latDifference + lngDifference);
    }

    /*TODO*/
    private int calculateBestMedoid(List<Place> places, ArrayList<Integer> clusterIndexes, int i) {
        return i;
    }

    
}
