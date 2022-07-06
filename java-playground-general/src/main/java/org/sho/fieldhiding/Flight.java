package org.sho.fieldhiding;

public class Flight {
    private int passengers;
    protected int seats = 150;

    private int totalCheckedBags;

    private int flightNumber;

    public Flight() {  }

    public Flight(int flightNumber) {
        this.flightNumber = flightNumber;

    }

    public void add1Passenger() {
        System.out.println("executing add1Passenger() with seats: " + seats);

        if(hasSeating())
            passengers += 1;
    }

    private boolean hasSeating() {

         return passengers < seats;
    }


    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getTotalCheckedBags() {
        return totalCheckedBags;
    }


}
