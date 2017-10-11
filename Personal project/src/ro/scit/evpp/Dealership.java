package ro.scit.evpp;

import java.util.*;

public class Dealership {

    private HashSet<Car> cars = new HashSet<>();
    private HashMap<Car, Integer> soldCars = new HashMap<>();
    private HashMap<Car, Integer> stockOfCars = new HashMap<>();
    private HashMap<Customer, Car> historyOfSales = new HashMap<>();
    private int request = 0;
    private float revenue;


    public void addCar(Car c, int stockNumber) {
        if (cars.contains(c)) {
            increaseStockNumber(c, stockNumber);
        } else {
            addNewCar(c, stockNumber);
        }
    }

    public void addNewCar(Car c, int stockNumber) {
        cars.add(c);
        stockOfCars.put(c, stockNumber);
    }

    private void increaseStockNumber(Car c, int stockNumber) {
        int count = stockOfCars.get(c) + stockNumber;
        stockOfCars.put(c, count);
    }

    public void removeCar(Car c, int stockNumber) {
        int count = stockOfCars.get(c);
        if (count == 1) {
            removeNewCar(c, stockNumber);
        } else {
            decreaseStockNumber(c, stockNumber);
        }
    }

    public void removeNewCar(Car c, int stockNumber) {
        cars.remove(c);
        stockOfCars.remove(c, stockNumber);
    }

    private void decreaseStockNumber(Car c, int stockNumber) {
        int count = stockOfCars.get(c) - stockNumber;
        stockOfCars.put(c, count);
    }

    public HashSet<Car> getCars() {
        return cars;
    }

    public Map<Car, Integer> getCarsInStock() {
        HashMap<Car, Integer> filteredCars = new HashMap<>();
        for (Car c : cars) {
            if (stockOfCars.get(c) > 0) {
                filteredCars.put(c, stockOfCars.get(c));
            }
        }
        return filteredCars;
    }


    public void addSales(Customer customer, Car car) {
        historyOfSales.put(customer, car);
    }

    public void soldCar(Customer customer, Car c, int amount) {
        soldCars.put(c, amount);
        removeCar(c, amount);
        revenue = revenue + (amount * c.getPrice());
        addSales(customer, c);
    }


    public ArrayList sortByPrice() {
        ArrayList sorted = new ArrayList(cars);
        Collections.sort(sorted, Car.priceComparator);
        return sorted;
    }

    public ArrayList sortByHorsePower() {
        ArrayList sorted = new ArrayList(cars);
        Collections.sort(sorted, Car.horsePowerComparator);
        return sorted;
    }

    public ArrayList sortByRange() {
        ArrayList sorted = new ArrayList(cars);
        Collections.sort(sorted, Car.rangePerChargeComparator);
        return sorted;
    }


    public HashMap<Car, Integer> filterByFastCharge() {
        LinkedHashMap<Car, Integer> filteredList = new LinkedHashMap<>();
        for (Car c : cars) {
            if (c.isFastCharge() == true) {
                filteredList.put(c, stockOfCars.get(c));
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

    public void setRevenue(float revenue) {
        this.revenue = revenue;
    }

    public int getRequest() {
        return request;
    }

    public void setRequest(int request) {
        this.request = request;
    }


}
