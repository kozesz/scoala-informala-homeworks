package test;

import org.junit.Test;
import ro.scit.evpp.*;

import static org.junit.Assert.assertEquals;

public class GreenBonusProgramTest {
    Car testCar = new Car("Volkswagen", "e-UP", true, 25000, 60, 160, true);

    @Test
    public void testGiveGreenBonusWithFunds(){
        GreenBonusProgram gbp  = new GreenBonusProgram(10000);

        assertEquals(10000, gbp.giveGreenBonus(testCar, 1), 0 );
    }

    @Test
    public void testGiveGreenBonusWithNoFunds(){
        GreenBonusProgram gbp  = new GreenBonusProgram(9000);

        assertEquals(0, gbp.giveGreenBonus(testCar, 1), 0 );
    }
}
