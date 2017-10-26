package ro.scit.evpp;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Dealership dealership = new Dealership();

        dealership.readMyCars();
        dealership.readSelectedCarToBuy();

        System.out.println("\nAll cars: " + dealership.getCars());
        System.out.println("\nThese cars are in fleet: " + dealership.getCarsInFleet());
        System.out.println("\nThe cars with fast charge " + dealership.getCarsfilteredByFastCharge());
        System.out.println("\nThe cars sorted by price " + dealership.getCarsSortedByPrice());
        System.out.println("\nThe cars sorted by horse power " + dealership.getCarsSortedByHorsePower());
        System.out.println("\nThe cars sorted by range per charge " + dealership.getCarsSortedByRangePerCharge());

        dealership.sellCar();

        System.out.println("The dealership's cars " + dealership.getCarsInFleet());
        System.out.println("The dealership's revenue is " + dealership.getRevenue());

    }

}
