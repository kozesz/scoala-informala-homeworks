package ro.scit.evpp;

import java.util.*;

/**
 * Created by Eszter on 8/25/2017
 * The dealership has a fleet of cars.
 */

public class Dealership {


    static Car[] dealership = new Car[9];

    public static void initCars(int position, String manufacturer, String model, boolean fastCharge, float price, int stockNumber) {
        dealership[position] = new Car();
        dealership[position].setManufacturer(manufacturer);
        dealership[position].setModel(model);
        dealership[position].setFastCharge(fastCharge);
        dealership[position].setPrice(price);
        dealership[position].setStockNumber(stockNumber);
    }

    public static ArrayList<Car> getListOfCars() {
        ArrayList<Car> listOfCars = new ArrayList<>(Arrays.asList(dealership));
        return listOfCars;
    }

    private final HashMap<Car, Integer> stock = new LinkedHashMap<>();


    public static List<String> filterByStockNumber() {
        List<String> listStock = new ArrayList<>();
        for (Car list : dealership) {
            if (list.getStockNumber() > 0) {
                listStock.add(list.getModel());
            }
        }
        return listStock;
    }

    public static List<String> filterByFastCharge() {
        List<String> listFastCharge = new ArrayList<>();
        for (Car list : dealership) {
            if (list.isFastCharge() == true) {
                listFastCharge.add(list.getModel());
            }
        }
        return listFastCharge;
    }
}

