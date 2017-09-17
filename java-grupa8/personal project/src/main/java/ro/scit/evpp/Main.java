package ro.scit.evpp;

/**
 * Created by Eszter on 8/25/2017
 * Customer retrieves list of ev cars and their prices from car dealership.
 * Customer is informed about the Green Bonus Program buget.
 */

import static ro.scit.evpp.Dealership.*;


public class Main {

    public static void main(String[] args) {

        initCars(0, "Volkswagen", "e-UP", 25000, 2, true);
        initCars(1, "Volkswagen", "e-Golf", 38000, 1, true);
        initCars(2, "Renault", "Zoe", 33000, 0, false);
        initCars(3, "BMW", "i3", 40000, 1, true);
        initCars(4, "Smart", "FourTwo", 22000, 0, false);
        initCars(5, "Smart", "FourFour", 22700, 3, false);
        initCars(6, "Smart", "FourTwo Cabrio", 23000, 0, false);
        initCars(7, "KIA", "Soul", 34000, 4, true);
        initCars(8, "Hyundai", "Ioniq", 23900, 0, false);

        for (Car list : dealership) {
            System.out.println(list.manufacturer + " " + list.model + " " + list.price + " " + list.stockNumber);
        }

        GreenBonusProgram buget = new GreenBonusProgram();
        System.out.println("The Green Bonus Program buget is " + buget.getBugetProgram());


        System.out.println("The following cars have fast charge: " + filterByFastCharge());
        System.out.println("The following cars are in stock: " + filterByStockNumber());


    }



}

