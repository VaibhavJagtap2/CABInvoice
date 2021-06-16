package com.cabinvoice;

public class InVoiceGenerator {
    private static final double MINIMUM_COST_PER_KILOMETER = 10.0;
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_FARE = 5;
    private Ridedemo ridedemo;

    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;

        return Math.max(totalFare,MINIMUM_FARE);
    }
    public InVoiceGenerator(){
        this.ridedemo = new Ridedemo();
    }
    public InVoiceSummary calculateFare(Ride[] rides){
        double totalFare = 0;
        for (Ride ride : rides){
            totalFare += this.calculateFare(ride.distance,ride.time);
        }
        return new InVoiceSummary(rides.length, totalFare);
    }
    public InVoiceSummary calculateFare(Ride[] rides,String type){
        double totalFare = 0;
        if(type == "premium"){
            for (Ride ride : rides){
                totalFare += this.calculateFare(ride.distance,ride.time);
            }
            return new InVoiceSummary(rides.length,totalFare);
        }
        for (Ride ride : rides){
            totalFare += this.calculateFare(ride.distance,ride.time);
        }
        return new InVoiceSummary(rides.length,totalFare);
    }
    public void addRides(String userID, Ride[] rides) {
        ridedemo.addRide(userID, rides);
    }
    public InVoiceSummary getInVoiceSummary(String userID) {
        return this.calculateFare(ridedemo.getRides(userID),"normal");
    }
}
