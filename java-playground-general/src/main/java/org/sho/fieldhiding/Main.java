package org.sho.fieldhiding;

public class Main {

    public static void main(String[] args) {
        inheritance_FieldHiding();
        inheritance_MethodOverriding();
    }

    private static void inheritance_FieldHiding() {
        System.out.println("***************************");
        System.out.println("Inheritance - Field hiding");
        System.out.println();

        System.out.println("Flight reference with Flight instance - seats");
        Flight f1 = new Flight();
        System.out.println(f1.seats);

        System.out.println();
        System.out.println("CargoFlight reference with CargoFlight instance - seats");
        CargoFlight cf = new CargoFlight();
        System.out.println(cf.seats);

        System.out.println();
        System.out.println("Flight reference with CargoFlight instance - seats");
        Flight f2 = new CargoFlight();
        System.out.println(f2.seats);

        System.out.println();
        System.out.println("Flight reference with CargoFlight instance - add1Passenger");
        f2.add1Passenger();

        System.out.println();
        System.out.println("CargoFlight reference with CargoFlight instance - add1Passenger");
        cf.add1Passenger();

        System.out.println("***************************");
        System.out.println();
    }

    private static void inheritance_MethodOverriding() {
        System.out.println("***************************");
        System.out.println("Inheritance - Method overriding");
        System.out.println();

        System.out.println("Flight reference with Flight instance - getSeats()");
        FlightWithGetter f1 = new FlightWithGetter();
        System.out.println(f1.getSeats());

        System.out.println();
        System.out.println("CargoFlight reference with CargoFlight instance - getSeats()");
        CargoFlightWithGetter cf = new CargoFlightWithGetter();
        System.out.println(cf.getSeats());

        System.out.println();
        System.out.println("Flight reference with CargoFlight instance - getSeats()");
        FlightWithGetter f2 = new CargoFlightWithGetter();
        System.out.println(f2.getSeats());

        System.out.println();
        System.out.println("Flight reference with CargoFlight instance - add1Passenger");
        f2.add1Passenger();

        System.out.println();
        System.out.println("CargoFlight reference with CargoFlight instance - add1Passenger");
        cf.add1Passenger();

        System.out.println("***************************");
        System.out.println();
    }
}

