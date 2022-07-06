package org.sho.fieldhiding;

public class FlightWithGetter {
    int passengers;
    int getSeats() {
        return 150;
    }

    private int totalCheckedBags;

    private int flightNumber;

    public FlightWithGetter() {  }

    public FlightWithGetter(int flightNumber) {
        this.flightNumber = flightNumber;

    }

    public void add1Passenger() {
        System.out.println("executing add1Passenger()");

        if (hasSeating())
            passengers += 1;
    }

    private boolean hasSeating() {
        System.out.println("executing hasSeating() - seats: " + getSeats());
        return passengers < getSeats();
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

