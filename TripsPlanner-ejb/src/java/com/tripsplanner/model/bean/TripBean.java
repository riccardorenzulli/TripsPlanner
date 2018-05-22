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
    
    /*Given the interesting places to be visited and the number of days
      return an arraylist for each cluster containing the indexes of the
      places belonging to the clusters.
    */
    public ArrayList<ArrayList<Integer>> buildTrip(List<Place> interestingPlaces, int dayTrips) {
        /*Clustering + shortest path tour*/
        Random rand = new Random();
        List<Place> places = interestingPlaces;
        int daysOfTrip = dayTrips;
        int numberOfPlaces = places.size();
        
        ArrayList<Integer> medoidsIndexes = new ArrayList<>();
        /*initializing centroids*/
        for(int i=0; i<daysOfTrip; i++) {
            boolean equalCentroids = true;
            /*create unique centroids*/
            while(equalCentroids) {
                int newIndex = rand.nextInt(numberOfPlaces);
                if(!medoidsIndexes.contains(newIndex)) { //need to use Integer object?
                    medoidsIndexes.add(newIndex);
                    equalCentroids = false;
                }
            }
        }
        
        ArrayList<ArrayList<Integer>> clusters = null;
        
        int iterations = 5;
        for(int it=0; it<iterations; it++) {
            /*Clean the clusters*/
            clusters = clusters = new ArrayList<>();
            for(int i=0; i<daysOfTrip; i++)
                clusters.add(new ArrayList<>());
            
            /*Assign places to the closest medoids*/
            for(int i=0; i<numberOfPlaces; i++) {
                int closestClusterIndex = getClosestCluster(places, medoidsIndexes, i);
                clusters.get(closestClusterIndex).add(i); //put the place i in the closest cluster
            }
            /*Recalculate medoids*/
            for(int i=0; i<medoidsIndexes.size(); i++) {
                int indexBestMedoid = calculateBestMedoid(places, clusters.get(i), i);
                medoidsIndexes.set(i, indexBestMedoid);
            }
        }
        
        
        
        for(int i=0; i<clusters.size(); i++) {
            System.out.println("Cluster_"+i+":{");
            for(int index : clusters.get(i))
                System.out.print(" "+index);
            System.out.print("}\n");
        }
        for(int i=0; i<places.size(); i++)
            System.out.println(places.get(i).getLat()+","+places.get(i).getLng()+","+i);
        
        return clusters;
    }

    private int getClosestCluster(List<Place> places, ArrayList<Integer> medoidsIndexes, int placeIndex) {
        int indexClosestCluster = 0;
        float minDistance = Float.MAX_VALUE;
        for(int i=0; i<medoidsIndexes.size(); i++) {
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

    /*Given the cluster, recalculate the medoid*/
    private int calculateBestMedoid(List<Place> places, ArrayList<Integer> clusterIndexes, int i) {
        int medoidIndex = clusterIndexes.get(0);
        float minDistancesSum = Float.MIN_VALUE;
        for(int index : clusterIndexes) {
            float distancesSum = 0;
            for(int otherIndex : clusterIndexes)
                distancesSum += getDistance(places.get(index), places.get(otherIndex));
            if(distancesSum < minDistancesSum)
                medoidIndex = index;
        }
        return medoidIndex;
    }

    
}
