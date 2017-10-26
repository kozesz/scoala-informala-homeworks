package test;

import org.junit.Test;
import ro.scit.evpp.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CarCSVReaderTest {

    @Test
    public void testReadingWithOneCarInCSV() {
        // given
        String csvAsString = "Kia/Soul/true/34000/150/170/true/2";
        BufferedReader br = new BufferedReader(new StringReader(csvAsString));
        CarCSVReader reader = new CarCSVReader(br);
        // when
        Map<Car, Integer> carIntegerMap = reader.readCars();
        // then
        Car expectedCar = new Car("Kia", "Soul", true, 34000, 150, 170, true);
        assertTrue(carIntegerMap.keySet().size() == 1);
        Car actual = carIntegerMap.keySet().iterator().next();
        assertEquals(expectedCar, actual);
        assertEquals(new Integer(2), carIntegerMap.get(actual));
    }

    @Test
    public void testReadingWithMultipleCars() {
        // given
        String csvAsString = "Smart/ForTwo/false/22000/80/158/true/1\nSmart/ForFour/false/22700/80/140/true/2\nSmart/ForTwo Cabrio/false/23000/80/158/false/3";
        BufferedReader br = new BufferedReader(new StringReader(csvAsString));
        CarCSVReader reader = new CarCSVReader(br);
        // when
        Map<Car, Integer> productIntegerMap = reader.readCars();
        // then
        Map<Car, Integer> expected = new HashMap<>();
        expected.put(new Car("Smart", "ForTwo", false, 22000, 80, 158, true), 1);
        expected.put(new Car("Smart", "ForFour", false, 22700, 80, 140, true), 2);
        expected.put(new Car("Smart", "ForTwo Cabrio", false, 23000, 80, 158, false), 3);
        assertEquals(expected, productIntegerMap);
    }

    @Test
    public void testReadingWithMultipleProducts_fromFile() throws FileNotFoundException {
        // given
        CarCSVReader reader = new CarCSVReader(new BufferedReader(new FileReader("test.csv")));
        // when
        Map<Car, Integer> productIntegerMap = reader.readCars();
        // then
        Map<Car, Integer> expected = new HashMap<>();
        expected.put(new Car("Smart", "ForTwo", false, 22000, 80, 158, true), 1);
        expected.put(new Car("Smart", "ForFour", false, 22700, 80, 140, true), 2);
        expected.put(new Car("Smart", "ForTwo Cabrio", false, 23000, 80, 158, false), 3);
        assertEquals(expected, productIntegerMap);
    }
}
