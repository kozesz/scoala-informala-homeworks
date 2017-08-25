package main.java.ro.scit.evpp;

/**
 * Created by Eszter on 8/25/2017
 * Customer retrieves list of ev cars and their prices from car dealership.
 * Customer is informed about the Green Bonus Program buget.
 */

import static main.java.ro.scit.evpp.Dealership.dealership;
import static main.java.ro.scit.evpp.Dealership.initCars;


public class Main {

    public static void main(String[] args) {

        initCars(0, "Volkswagen", "e-UP", 25000);
        initCars(1, "Volkswagen", "e-Golf", 38000);
        initCars(2, "Renault", "Zoe", 33000);
        initCars(3, "BMW", "i3", 40000);
        initCars(4, "Smart", "FourTwo", 22000);
        initCars(5, "Smart", "FourFour", 22700);
        initCars(6, "Smart", "FourTwo Cabrio", 23000);
        initCars(7, "KIA", "Soul", 34000);
        initCars(8, "Hyundai", "Ioniq", 23900);

        for (int i = 0; i < 9; i++) {
            System.out.println(dealership[i].manufacturer + " " + dealership[i].model + " " + dealership[i].price);
        }

        GreenBonusProgram buget = new GreenBonusProgram();
        System.out.println("The Green Bonus Program buget is " + buget.getBugetProgram());

    }

}

