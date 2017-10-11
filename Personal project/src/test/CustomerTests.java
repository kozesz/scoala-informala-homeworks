package test;

import org.junit.Test;
import ro.scit.evpp.*;


import java.util.HashMap;

import static org.junit.Assert.assertEquals;


public class CustomerTests {

    Car carToBuy = new Car("Volkswagen", "e-UP", true, 25000, 60, 160, true);



    @Test
    public void testBuyCar(){
        Customer testCustomer = new Customer("Test", 45000);

        testCustomer.buyCar(carToBuy,1);
        assertEquals(20000, testCustomer.getBuget(),0);

    }

    @Test
    public void testCustomerCars(){
        HashMap<Car, Integer> customerStock = new HashMap<>();
        customerStock.put(carToBuy, 1);
        customerStock.entrySet().equals(carToBuy);

    }

}
