package ro.scit.evpp;

/**
 * Created by Eszter on 8/25/2017
 * Customer retrieves list of ev cars and their prices from car dealership.
 * Customer is informed about the Green Bonus Program buget.
 */

import java.util.Collections;

import static ro.scit.evpp.Dealership.*;


public class Main {

    public static void main(String[] args) {

        initCars(0, "Volkswagen", "e-UP", true, 25000, 2);
        initCars(1, "Volkswagen", "e-Golf", true, 38000, 1);
        initCars(2, "Renault", "Zoe", false, 33000, 0);
        initCars(3, "BMW", "i3", true, 40000, 1);
        initCars(4, "Smart", "FourTwo", false, 22000, 0);
        initCars(5, "Smart", "FourFour", false, 22700, 3);
        initCars(6, "Smart", "FourTwo Cabrio", false, 23000, 0);
        initCars(7, "KIA", "Soul", true, 34000, 1);
        initCars(8, "Hyundai", "Ioniq", false, 23900, 0);

        for (Car list : dealership) {
            System.out.println(list.getManufacturer() + " " + list.getModel() + " " + list.getPrice() + " " + list.getStockNumber());
        }

        GreenBonusProgram buget = new GreenBonusProgram();
        System.out.println("The Green Bonus Program buget is " + buget.getBugetProgram());


        System.out.println("The following cars have fast charge: " + filterByFastCharge());
        System.out.println("The following cars are in stock: " + filterByStockNumber());


    }


}