package test;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import ro.scit.evpp.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import static org.junit.Assert.*;

public class DealershipTests {
    Dealership testDealership = new Dealership();

    Car selectedCar = new Car("BMW", "i3", false, 40000, 135, 120, false);
    Car selectedCar2 = new Car("Renault", "Zoe", true, 33000, 68, 210, true);
    Car selectedCar3 = new Car("Volkswagen", "e-UP", true, 25000, 160, 160, true);

    Customer customer = new Customer("Eszter", 50000);

    @Test
    public void addCarTestToEmptyList() {
        testDealership.addCar(selectedCar, 3);

        assertEquals(1, testDealership.getCars().size());
        assertEquals(3, testDealership.getCarsInFleet().get(selectedCar), 0);
    }

    @Test
    public void addCarTestToNotEmptyList() {

        testDealership.addCar(selectedCar, 3);
        testDealership.addCar(selectedCar, 1);
        testDealership.addCar(selectedCar2, 7);

        assertEquals(2, testDealership.getCars().size());
        assertEquals(11, testDealership.getCarsInFleet().get(selectedCar) + testDealership.getCarsInFleet().get(selectedCar2), 0);
    }

    @Test
    public void removeCarTest() {
        testDealership.addCar(selectedCar, 3);
        testDealership.removeCar(selectedCar,1);

        assertEquals(1, testDealership.getCars().size());
        assertEquals(2, testDealership.getCarsInFleet().get(selectedCar), 0);
    }

    @Test
    public void removeLastCarTest() {
        testDealership.addCar(selectedCar, 1);
        testDealership.removeLastCar(selectedCar,1);

        assertEquals(0, testDealership.getCars().size());
        assertEquals(0, testDealership.getCarsInFleet().size(), 0);
    }

    @Test
    public void increaseStockNumberTest(){
        testDealership.addCar(selectedCar, 1);
        testDealership.addCar(selectedCar, 2);

        assertEquals(3, testDealership.getCarsInFleet().get(selectedCar), 0);
    }

    @Test
    public void decreaseStockNumberTest(){
        testDealership.addCar(selectedCar3, 3);
        testDealership.removeCar(selectedCar3, 1);

        assertEquals(2, testDealership.getCarsInFleet().get(selectedCar3), 0);
    }

    @Test
    public void sellCarWithNoFundsTest() throws Dealership.InsufficientFundsException, Dealership.OutOfStockException {
        Customer customer1 = new Customer("Eszter", 5000);
        testDealership.sellCar(selectedCar, 1, customer1);
        ExpectedException thrown = ExpectedException.none();

        thrown.expect(Dealership.InsufficientFundsException.class);
    }

    @Test
    public void requestBonusWithOldCarTest() throws GreenBonusProgram.InsufficientFundsException, Dealership.OldCarException, InterruptedException {
        ExpectedException thrown = ExpectedException.none();
        testDealership.requestGreenBonus(selectedCar, 1, customer);

        thrown.expect(Dealership.OldCarException.class);
    }

    @Test
    public void addSalesTest(){
        testDealership.addSales(customer,selectedCar);

        assertTrue(testDealership.getHistoryOfSales().containsKey(customer));
        assertTrue(testDealership.getHistoryOfSales().containsValue(selectedCar));
    }


    @Test
    public void getCarsSortByPriceTest() {
        testDealership.addCar(selectedCar, 1);
        testDealership.addCar(selectedCar2, 1);
        testDealership.addCar(selectedCar3, 1);

        ArrayList<Car> expected = new ArrayList<>();
        expected.add(selectedCar3);
        expected.add(selectedCar2);
        expected.add(selectedCar);

        assertEquals(expected, testDealership.getCarsSortedByPrice());
    }

    @Test
    public void getCarSortByHorsePowerTest() {
        testDealership.addCar(selectedCar, 1);
        testDealership.addCar(selectedCar2, 1);
        testDealership.addCar(selectedCar3, 1);

        ArrayList<Car> expected = new ArrayList<>();
        expected.add(selectedCar2);
        expected.add(selectedCar);
        expected.add(selectedCar3);

        assertEquals(expected, testDealership.getCarsSortedByHorsePower());
    }

    @Test
    public void GetCarsSortByRangeTest() {
        testDealership.addCar(selectedCar, 1);
        testDealership.addCar(selectedCar2, 1);
        testDealership.addCar(selectedCar3, 1);

        ArrayList<Car> expected = new ArrayList<>();
        expected.add(selectedCar);
        expected.add(selectedCar3);
        expected.add(selectedCar2);

        assertEquals(expected, testDealership.getCarsSortedByRangePerCharge());
    }



}
