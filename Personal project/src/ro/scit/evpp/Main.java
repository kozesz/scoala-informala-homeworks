package ro.scit.evpp;

import java.util.*;


public class Main {

    public static void main(String[] args) {

        Customer customer = new Customer("Eszter", 36000);
        Dealership dealership = new Dealership();
        GreenBonusProgram greenBonusProgram = new GreenBonusProgram(100000);
        Car selectedCar = new Car("Renault", "Zoe", true, 33000, 68, 210, true);
        int amountOfCar = 1;
        float theBonus = 0;

        dealership.addCar(new Car("Volkswagen", "e-UP", true, 25000, 60, 160, true), 3);
        dealership.addCar(new Car("Volkswagen", "e-Golf", false, 38000, 100, 300, false), 0);
        dealership.addCar(new Car("Renault", "Zoe", true, 33000, 68, 210, true), 2);


        System.out.println("\nAll cars: " + dealership.getCars());
        System.out.println("\nThese cars are in stock: " + dealership.getCarsInStock());
        System.out.println("\nThe cars with fast charge " + dealership.filterByFastCharge());
        System.out.println("\nThe cars sorted by price " + dealership.sortByPrice());
        System.out.println("\nThe cars sorted by horse power " + dealership.sortByHorsePower());
        System.out.println("\nThe cars sorted by range per charge " + dealership.sortByRange());

        if (customer.getBuget() < selectedCar.getPrice()) {
            System.out.println("You can't buy this car, you don't have enough money.");
        } else {
            if (!dealership.getCarsInStock().containsKey(selectedCar)) {
                System.out.println("You can't buy this car, it is out of stock.");
            } else {
                customer.buyCar(selectedCar, amountOfCar);
                System.out.println(customer.getBuget());
                System.out.println(customer.getCustomerStock());
                dealership.soldCar(customer, selectedCar, amountOfCar);
                System.out.println(dealership.getCarsInStock());
                System.out.println(dealership.getRevenue());
            }
        }

        if (dealership.getSoldCars().get(selectedCar) > 0) {
            if (selectedCar.isItNew()) {
                theBonus = greenBonusProgram.giveGreenBonus(selectedCar, amountOfCar);
                customer.receiveBonus(theBonus);
                System.out.println(customer.getBuget());
                System.out.println(greenBonusProgram.getBuget());
            } else System.out.println("The car you bought is not new, you don't get the 10.000 euro bonus.");
        } else System.out.println("You need to buy a new electric car in order to receive the 10.000 euro bonus.");

    }
}
