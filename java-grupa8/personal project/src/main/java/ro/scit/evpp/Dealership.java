package ro.scit.evpp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eszter on 8/25/2017
 * The dealership has a fleet of cars.
 */

public class Dealership {

    static Car[] dealership = new Car[9];

    public static void initCars(int position, String manufacturer, String model, int price, int stockNumber, boolean fastCharge) {
        dealership[position] = new Car();
        dealership[position].manufacturer = manufacturer;
        dealership[position].model = model;
        dealership[position].price = price;
        dealership[position].stockNumber = stockNumber;
        dealership[position].fastCharge = fastCharge;
    }

    public static List<String> filterByStockNumber() {
        List<String> listStock = new ArrayList<>();
        for (Car list : dealership) {
            if (list.stockNumber > 0) {
                listStock.add(list.model);
            }
        }
        return listStock;
    }

    public static List<String> filterByFastCharge() {
        List<String> listFastCharge = new ArrayList<>();
        for (Car list : dealership) {
            if (list.fastCharge == true) {
                listFastCharge.add(list.model);
            }
        }
        return listFastCharge;
    }
}










