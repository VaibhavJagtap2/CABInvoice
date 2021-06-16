package com.cabinvoice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Ridedemo {
    Map<String, ArrayList<Ride>> userRides = null;

    public Ridedemo(){
        this.userRides = new HashMap<>();
    }
    public void addRide(String userID, Ride[] rides) {
        this.userRides.put(userID,new ArrayList<>(Arrays.asList(rides)));
    }
    public Ride[] getRides(String userID){
        return this.userRides.get(userID).toArray(new Ride[0]);
    }
}
