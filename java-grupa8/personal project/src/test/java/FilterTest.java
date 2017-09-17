package ro.scit.evpp;

import com.sun.org.apache.xerces.internal.xs.StringList;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static ro.scit.evpp.Dealership.*;

public class FilterTest {

    @Before
    public void mySteUp() throws Exception {
        initCars(0, "Volkswagen", "e-UP", 25000, 2, true);
        initCars(1, "Volkswagen", "e-Golf", 38000, 1, true);
        initCars(2, "Renault", "Zoe", 33000, 0, false);
        initCars(3, "BMW", "i3", 40000, 1, true);
        initCars(4, "Smart", "FourTwo", 22000, 0, false);
        initCars(5, "Smart", "FourFour", 22700, 3, false);
        initCars(6, "Smart", "FourTwo Cabrio", 23000, 0, false);
        initCars(7, "KIA", "Soul", 34000, 4, true);
        initCars(8, "Hyundai", "Ioniq", 23900, 0, false);
    }

    @Test
    public void testFilterByStock() throws Exception {
        List<String> listForStock = new ArrayList<>(Arrays.asList("e-UP", "e-Golf", "i3", "FourFour", "Soul"));
        assertEquals(listForStock, filterByStockNumber());
    }

    @Test
    public void testFilterByFastCharge() throws Exception {
        List<String> listForStock = new ArrayList<>(Arrays.asList("e-UP", "e-Golf", "i3", "Soul"));
        assertEquals(listForStock, filterByFastCharge());
    }
}
