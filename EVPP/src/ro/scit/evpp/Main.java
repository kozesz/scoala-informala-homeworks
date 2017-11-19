package ro.scit.evpp;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException, Dealership.InsufficientFundsException, Dealership.OutOfStockException, Dealership.OldCarException, GreenBonusProgram.InsufficientFundsException {
        Customer customer = new Customer("Eszter", 100000);
        Dealership dealership = new Dealership();

        dealership.readMyCars();
        dealership.readMyCarsToBuy();

        System.out.println("\nAll cars: " + dealership.getCars());
        System.out.println("\nThese cars are in fleet: " + dealership.getCarsInFleet());
        System.out.println("\nThe cars with fast charge " + dealership.getCarsFilteredByFastCharge());
        System.out.println("\nThe cars sorted by price " + dealership.getCarsSortedByPrice());
        System.out.println("\nThe cars sorted by horse power " + dealership.getCarsSortedByHorsePower());
        System.out.println("\nThe cars sorted by range per charge " + dealership.getCarsSortedByRangePerCharge());

        Set<Map.Entry<Car, Integer>> cars = dealership.getCarsToBuy().entrySet();
        for (Map.Entry<Car, Integer> thisList : cars) {

            Thread transaction = new Thread(new Dealership()) {
                public void run() {
                    try {
                        dealership.sellCar(thisList.getKey(), thisList.getValue(), customer);
                        dealership.requestGreenBonus(thisList.getKey(), thisList.getValue(), customer);
                    } catch (Dealership.InsufficientFundsException e) {
                        e.printStackTrace();
                    } catch (Dealership.OutOfStockException e) {
                        e.printStackTrace();
                    } catch (Dealership.OldCarException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (GreenBonusProgram.InsufficientFundsException e) {
                        e.printStackTrace();
                    }
                }
            };

            transaction.start();
            try {
                transaction.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}







