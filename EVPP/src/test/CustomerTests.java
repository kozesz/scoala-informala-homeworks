package test;

import org.junit.Test;
import ro.scit.evpp.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class CustomerTests {

    Car carToBuy = new Car("Volkswagen", "e-UP", true, 25000, 60, 160, true);
    Customer testCustomer = new Customer("Test", 50000);

    @Test
    public void testBuyCar() {
        testCustomer.setBuget(45000);
        testCustomer.buyCar(carToBuy, 1);
        assertEquals(20000, testCustomer.getBuget(), 0);
    }

    @Test
    public void testCustomerCars() {
        testCustomer.buyCar(carToBuy, 1);
        assertTrue(1 == testCustomer.getCustomerFleet().size());
        assertEquals(1, testCustomer.getCustomerFleet().get(carToBuy), 0);
    }

    @Test
    public void testCustomerReceivedBonus() {
        testCustomer.setBuget(25000);
        testCustomer.buyCar(carToBuy, 1);
        assertEquals(0, testCustomer.getBuget(), 0);
    }
}
