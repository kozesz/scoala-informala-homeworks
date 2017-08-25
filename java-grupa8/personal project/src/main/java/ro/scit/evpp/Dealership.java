package main.java.ro.scit.evpp;

/**
 * Created by Eszter on 8/25/2017
 * The dealership has a fleet of cars.
 */

public class Dealership {

    static Car[] dealership = new Car[20];

    public static void initCars(int position, String manufacturer, String model, int price) {
        dealership[position] = new Car();
        dealership[position].manufacturer = manufacturer;
        dealership[position].model = model;
        dealership[position].price = price;
    }

}










