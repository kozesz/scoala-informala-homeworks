package ro.scit.evpp;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException, Dealership.InsufficientFundsException, Dealership.OutOfStockException, Dealership.OldCarException, GreenBonusProgram.InsufficientFundsException {

        Dealership dealership = new Dealership();
        Customer customer = new Customer("Eszter", 50000);

        dealership.readMyCars();
        dealership.readMyCarsToBuy();

        System.out.println("\nAll cars: " + dealership.getCars());
        System.out.println("\nThese cars are in fleet: " + dealership.getCarsInFleet());
        System.out.println("\nThe cars with fast charge " + dealership.getCarsFilteredByFastCharge());
        System.out.println("\nThe cars sorted by price " + dealership.getCarsSortedByPrice());
        System.out.println("\nThe cars sorted by horse power " + dealership.getCarsSortedByHorsePower());
        System.out.println("\nThe cars sorted by range per charge " + dealership.getCarsSortedByRangePerCharge());


        System.out.println("Do you want to buy a car?");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        try {
            if (userInput.equalsIgnoreCase("yes")) {
                Set<Map.Entry<Car, Integer>> cars = dealership.getCarsToBuy().entrySet();

                if (cars.size() > 0) {
                    for (Map.Entry<Car, Integer> thisList : cars) {
                        System.out.println(thisList.getKey() + " - number " + thisList.getValue());
                        System.out.println("Do you want to buy this car?");
                        userInput = scanner.nextLine();

                        if (userInput.equalsIgnoreCase("yes")) {
                            dealership.sellCar(thisList.getKey(), thisList.getValue(), customer);
                            System.out.println("Do you want to use the Green Bonus Program?");
                            userInput = scanner.nextLine();
                            if (userInput.equalsIgnoreCase("yes")) {
                                dealership.requestGreenBonus(thisList.getKey(), thisList.getValue(), customer);
                            } else throw new UserInputException();
                        } else throw new UserInputException();
                    }
                } else System.out.println("Please insert the car(s) you want to buy in the CarToBuy.csv file");

            } else throw new UserInputException();

        } catch (UserInputException e) {
            System.out.println("Thank you for stopping by.");
        }
    }
}






