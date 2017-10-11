package test;

import org.junit.Test;
import ro.scit.evpp.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DealershipTests {
    Dealership testDealership = new Dealership();

    Car selectedCar = new Car("BMW", "i3", false, 40000, 135, 120, true);
    Car selectedCar2 = new Car("Renault", "Zoe", true, 33000, 68, 210, true);
    Car selectedCar3 = new Car("Volkswagen", "e-UP", true, 25000, 160, 160, true);

    Customer customer = new Customer("Eszter", 50000);

    @Test
    public void addCarTestToEmpptyList() {
        testDealership.addCar(selectedCar, 3);

        assertEquals(1, testDealership.getCars().size());
        assertEquals(3, testDealership.getCarsInStock().get(selectedCar), 0);
    }

    @Test
    public void addCarTestToNotEmptyList() {

        testDealership.addCar(selectedCar, 3);
        testDealership.addCar(selectedCar, 1);
        testDealership.addCar(selectedCar2, 7);

        assertEquals(2, testDealership.getCars().size());
        assertEquals(11, testDealership.getCarsInStock().get(selectedCar) + testDealership.getCarsInStock().get(selectedCar2), 0);
    }

    @Test
    public void removeCarTest() {
        testDealership.addCar(selectedCar, 3);
        testDealership.removeCar(selectedCar,1);

        assertEquals(1, testDealership.getCars().size());
        assertEquals(2, testDealership.getCarsInStock().get(selectedCar), 0);
    }

    @Test
    public void removeLastCarTest() {
        testDealership.addCar(selectedCar, 1);
        testDealership.removeCar(selectedCar,1);

        assertEquals(0, testDealership.getCars().size());
        assertEquals(0, testDealership.getCarsInStock().size(), 0);
    }

    @Test
    public void soldCarTest() {
        testDealership.addCar(selectedCar, 2);
        testDealership.soldCar(customer, selectedCar,1);

        assertEquals(selectedCar.getPrice(), testDealership.getRevenue(), 0);
        assertEquals(1, testDealership.getCarsInStock().size(), 0);
    }

    @Test
    public void sortByPriceTest() {
        testDealership.addCar(selectedCar, 1);
        testDealership.addCar(selectedCar2, 1);
        testDealership.addCar(selectedCar3, 1);

        ArrayList<Car> expected = new ArrayList<>();
        expected.add(selectedCar3);
        expected.add(selectedCar2);
        expected.add(selectedCar);

        testDealership.sortByPrice();

        assertEquals(expected, testDealership.sortByPrice());
    }

    @Test
    public void sortByHorsePowerTest() {
        testDealership.addCar(selectedCar, 1);
        testDealership.addCar(selectedCar2, 1);
        testDealership.addCar(selectedCar3, 1);

        ArrayList<Car> expected = new ArrayList<>();
        expected.add(selectedCar2);
        expected.add(selectedCar);
        expected.add(selectedCar3);

        testDealership.sortByHorsePower();

        assertEquals(expected, testDealership.sortByHorsePower());
    }

    @Test
    public void sortByRangeTest() {
        testDealership.addCar(selectedCar, 1);
        testDealership.addCar(selectedCar2, 1);
        testDealership.addCar(selectedCar3, 1);

        ArrayList<Car> expected = new ArrayList<>();
        expected.add(selectedCar);
        expected.add(selectedCar3);
        expected.add(selectedCar2);

        testDealership.sortByRange();

        assertEquals(expected, testDealership.sortByRange());
    }
}
