package com.cabinvoice;

public class InVoiceSummary {
    private final int numOfRides;
    private final double totalFare;
    private final double avgFare;

    public InVoiceSummary(int numOfRides, double totalFare) {
        this.numOfRides = numOfRides;
        this.totalFare = totalFare;
        this.avgFare = this.totalFare / this.numOfRides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InVoiceSummary that = (InVoiceSummary) o;
        return numOfRides == that.numOfRides && Double.compare(that.totalFare, totalFare) == 0 && Double.compare(that.avgFare, avgFare) == 0;
    }
}