package ro.scit.evpp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Dealership {

    Customer customer = new Customer("Eszter");
    GreenBonusProgram greenBonusProgram = new GreenBonusProgram();
    private HashSet<Car> cars = new HashSet<>();
    private HashMap<Car, Integer> soldCars = new HashMap<>();
    private HashMap<Car, Integer> fleetOfCars = new HashMap<>();
    private HashMap<Customer, Car> historyOfSales = new HashMap<>();
    Car selectedCarToBuy = null;
    private int amountOfCar = 0;
    private int revenue = 0;

    public void readMyCars() throws IOException {
        CarCSVReader carReader = new CarCSVReader(new BufferedReader(new FileReader("cars.csv")));
        Map<Car, Integer> carIntegerMap = carReader.readCars();
        for (Car car : carIntegerMap.keySet()) {
            addCar(car, carIntegerMap.get(car));
        }
        carReader.close();
    }

    public void readSelectedCarToBuy() throws IOException {
        CarCSVReader carToBuyReader = new CarCSVReader(new BufferedReader(new FileReader("carToBuy.csv")));
        Map<Car, Integer> carToBuyIntegerMap = carToBuyReader.readCars();
        for (Car car : carToBuyIntegerMap.keySet()) {
            selectedCarToBuy = car;
            amountOfCar = carToBuyIntegerMap.get(car);
        }
        carToBuyReader.close();
    }

    public void addCar(Car c, int stockNumber) {
        if (cars.contains(c)) {
            increaseStockNumber(c, stockNumber);
        } else {
            addNewCar(c, stockNumber);
        }
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
            removeNewCar(c, stockNumber);
        } else {
            decreaseStockNumber(c, stockNumber);
        }
    }

    public void removeNewCar(Car c, int stockNumber) {
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


    public void sellCar() {

        if (customer.getBuget() >= (selectedCarToBuy.getPrice() * amountOfCar)) {
            if (getCarsInFleet().containsKey(selectedCarToBuy)) {
                soldCars.put(selectedCarToBuy, amountOfCar);
                removeCar(selectedCarToBuy, amountOfCar);
                revenue = revenue + (amountOfCar * selectedCarToBuy.getPrice());
                addSales(customer, selectedCarToBuy);
                customer.buyCar(selectedCarToBuy, amountOfCar);
                System.out.println("The customer's remaining buget is " + customer.getBuget());
                System.out.println("The customer's car(s): " + customer.getCustomerFleet());
                if (selectedCarToBuy.isItNew()) {
                    customer.receiveBonus(greenBonusProgram.giveGreenBonus(customer, selectedCarToBuy, amountOfCar));
                } else System.out.println("The car you bought is not new, you don't get the 10.000 euro bonus.");
            } else System.out.println("You can't buy this car, it is out of stock.");
        } else {
            System.out.println("You can't buy this car, you don't have enough money.");
        }
    }

    public ArrayList getCarsSortedByPrice() {
        ArrayList sorted = new ArrayList(cars);
        Collections.sort(sorted, Car.priceComparator);
        return sorted;
    }

    public ArrayList getCarsSortedByHorsePower() {
        ArrayList sorted = new ArrayList(cars);
        Collections.sort(sorted, Car.horsePowerComparator);
        return sorted;
    }

    public ArrayList getCarsSortedByRangePerCharge() {
        ArrayList sorted = new ArrayList(cars);
        Collections.sort(sorted, Car.rangePerChargeComparator);
        return sorted;
    }

    public HashMap<Car, Integer> getCarsfilteredByFastCharge() {
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

}
