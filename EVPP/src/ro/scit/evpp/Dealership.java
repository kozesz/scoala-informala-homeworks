package ro.scit.evpp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Dealership extends Thread {


    GreenBonusProgram greenBonusProgram = new GreenBonusProgram();
    private HashSet<Car> cars = new HashSet<>();
    private HashMap<Car, Integer> carsToBuy = new HashMap<>();
    private HashMap<Car, Integer> soldCars = new HashMap<>();
    private HashMap<Car, Integer> fleetOfCars = new HashMap<>();
    private HashMap<Customer, Car> historyOfSales = new HashMap<>();
    private int revenue = 0;


    public void readMyCars() throws IOException {
        CarCSVReader carReader = new CarCSVReader(new BufferedReader(new FileReader("cars.csv")));
        Map<Car, Integer> carIntegerMap = carReader.readCars();
        for (Car car : carIntegerMap.keySet()) {
            addCar(car, carIntegerMap.get(car));
        }
        carReader.close();
    }

    public void readMyCarsToBuy() throws IOException {
        CarCSVReader carReader = new CarCSVReader(new BufferedReader(new FileReader("carToBuy.csv")));
        Map<Car, Integer> carIntegerMap = carReader.readCars();
        for (Car car : carIntegerMap.keySet()) {
            addCarToBuy(car, carIntegerMap.get(car));
        }
        carReader.close();
    }

    public void addCar(Car c, int stockNumber) {
        if (cars.contains(c)) {
            increaseStockNumber(c, stockNumber);
        } else {
            addNewCar(c, stockNumber);
        }
    }

    public void addCarToBuy(Car c, int stockNumber) {
        carsToBuy.put(c, stockNumber);
    }


    private void addNewCar(Car c, int stockNumber) {
        cars.add(c);
        fleetOfCars.put(c, stockNumber);
    }

    private void increaseStockNumber(Car c, int stockNumber) {
        int count = fleetOfCars.get(c) + stockNumber;
        fleetOfCars.put(c, count);
    }

    public void removeCar(Car c, int stockNumber) {
        int count = fleetOfCars.get(c);
        if (count == 1) {
            removeLastCar(c, stockNumber);
        } else {
            decreaseStockNumber(c, stockNumber);
        }
    }

    public void removeLastCar(Car c, int stockNumber) {
        cars.remove(c);
        fleetOfCars.remove(c, stockNumber);
    }

    private void decreaseStockNumber(Car c, int stockNumber) {
        int count = fleetOfCars.get(c) - stockNumber;
        fleetOfCars.put(c, count);
    }

    public HashSet<Car> getCars() {
        return cars;
    }

    public Map<Car, Integer> getCarsInFleet() {
        HashMap<Car, Integer> filteredCars = new HashMap<>();
        for (Car c : cars) {
            if (fleetOfCars.get(c) > 0) {
                filteredCars.put(c, fleetOfCars.get(c));
            }
        }
        return filteredCars;
    }

    public void addSales(Customer customer, Car car) {
        historyOfSales.put(customer, car);
    }

    public void sellCar(Car selectedCarToBuy, Integer amountOfCar, Customer customer) throws InsufficientFundsException, OutOfStockException {
        if (customer.getBuget() >= (selectedCarToBuy.getPrice() * amountOfCar)) {
            if (getCarsInFleet().containsKey(selectedCarToBuy)) {
                soldCars.put(selectedCarToBuy, amountOfCar);
                removeCar(selectedCarToBuy, amountOfCar);
                revenue = revenue + (amountOfCar * selectedCarToBuy.getPrice());
                addSales(customer, selectedCarToBuy);
                customer.buyCar(selectedCarToBuy, amountOfCar);
                System.out.println("The customer's remaining buget is " + customer.getBuget());
                System.out.println("The customer's car(s): " + customer.getCustomerFleet());
                System.out.println("The dealership's revenue is " + getRevenue());
            } else throw new OutOfStockException();
        } else throw new InsufficientFundsException();
    }

    public void requestGreenBonus(Car selectedCarToBuy, Integer amountOfCar, Customer customer) throws OldCarException, GreenBonusProgram.InsufficientFundsException {
        if (selectedCarToBuy.isItNew()) {
            customer.receiveBonus(greenBonusProgram.giveGreenBonus(customer, selectedCarToBuy, amountOfCar));
        } else throw new OldCarException();
    }


    public ArrayList<Car> getCarsSortedByPrice() {
        ArrayList sorted = new ArrayList(cars);
        Collections.sort(sorted, Car.priceComparator);
        return sorted;
    }

    public ArrayList<Car> getCarsSortedByHorsePower() {
        ArrayList sorted = new ArrayList(cars);
        Collections.sort(sorted, Car.horsePowerComparator);
        return sorted;
    }

    public ArrayList<Car> getCarsSortedByRangePerCharge() {
        ArrayList sorted = new ArrayList(cars);
        Collections.sort(sorted, Car.rangePerChargeComparator);
        return sorted;
    }

    public HashMap<Car, Integer> getCarsFilteredByFastCharge() {
        LinkedHashMap<Car, Integer> filteredList = new LinkedHashMap<>();
        for (Car c : cars) {
            if (c.isFastCharge() == true) {
                filteredList.put(c, fleetOfCars.get(c));
            }
        }
        return filteredList;
    }

    public HashMap<Car, Integer> getSoldCars() {
        return soldCars;
    }

    public void setSoldCars(HashMap<Car, Integer> soldCars) {
        this.soldCars = soldCars;
    }

    public float getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public HashMap<Customer, Car> getHistoryOfSales() {
        return historyOfSales;
    }

    public HashMap<Car, Integer> getCarsToBuy() {
        return carsToBuy;
    }

    public void setCarsToBuy(HashMap<Car, Integer> carsToBuy) {
        this.carsToBuy = carsToBuy;
    }

    public class InsufficientFundsException extends Exception {
        public InsufficientFundsException() {
            System.out.println("You can't buy this car, you don't have enough money.");
        }
    }

    public class OutOfStockException extends Exception {
        public OutOfStockException() {
            System.out.println("You can't buy this car, it is out of stock.");
        }
    }

    public class OldCarException extends Exception {
        public OldCarException() {
            System.out.println("You can't request a Green Bonus, it's only for new cars.");
        }
    }
}
