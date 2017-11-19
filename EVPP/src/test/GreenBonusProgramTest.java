package test;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import ro.scit.evpp.*;

import static org.junit.Assert.assertEquals;

public class GreenBonusProgramTest {
    Car testCar = new Car("Volkswagen", "e-UP", true, 25000, 60, 160, true);
    GreenBonusProgram testGBProgram = new GreenBonusProgram();
    Customer testCustomer = new Customer("Test", 50000);

    @Test
    public void testGiveGreenBonusWithFunds() throws GreenBonusProgram.InsufficientFundsException {
        testGBProgram.setBuget(20000);
        assertEquals(20000, testGBProgram.giveGreenBonus(testCustomer, testCar, 2), 0);
    }

    @Test
    public void testGiveGreenBonusWithNoFunds() throws GreenBonusProgram.InsufficientFundsException {
        ExpectedException thrown = ExpectedException.none();
        testGBProgram.setBuget(9000);
        testGBProgram.giveGreenBonus(testCustomer, testCar, 1);
        thrown.expect(GreenBonusProgram.InsufficientFundsException.class);
    }

    @Test
    public void testGiveGreenBonusPartially() throws GreenBonusProgram.InsufficientFundsException {
        testGBProgram.setBuget(19000);
        assertEquals(10000, testGBProgram.giveGreenBonus(testCustomer, testCar, 2), 0);

    }
}
