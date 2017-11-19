package ro.scit.evpp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CarCSVReader extends Reader {
    private BufferedReader reader;
    public CarCSVReader(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return reader.read(cbuf, off, len);
    }

    public Map<Car, Integer> readCars() {
        try {
            String line = reader.readLine();
            HashMap<Car, Integer> carsAndStock = new LinkedHashMap<>();
            while (line != null) {
                String[] tokens = line.split("/");
                String manufacturer = tokens[0];
                String model = tokens[1];
                boolean fastCharge = Boolean.parseBoolean(tokens[2]);
                int price = Integer.parseInt(tokens[3]);
                int horsePower = Integer.parseInt(tokens[4]);
                int rangePerCharge = Integer.parseInt(tokens[5]);
                boolean isItNew = Boolean.parseBoolean(tokens[6]);
                int stockNumber = Integer.parseInt(tokens[7]);
                Car car = new Car(manufacturer, model, fastCharge, price, horsePower, rangePerCharge, isItNew);
                carsAndStock.put(car, stockNumber);
                line = reader.readLine();
            }
            return carsAndStock;
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return Collections.emptyMap();
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }

}
