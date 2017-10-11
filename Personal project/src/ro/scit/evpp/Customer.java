package ro.scit.evpp;

import java.util.HashMap;
import java.util.HashSet;

public class Customer {

    private String name;
    private float buget;
    private HashMap<Car, Integer> customerStock = new HashMap<>();
    private int request = 0;

    public float getBuget() {
        return buget;
    }

    public void setBuget(float buget) {
        this.buget = buget;
    }

    public Customer(String name, float buget) {
        this.name = name;
        this.buget = buget;
    }

    public int buyCar(Car c, int amount) {
        buget = buget - (amount * c.getPrice());
        putCarInStock(c, amount);
        request = 1;
        return request;
    }

    private void putCarInStock(Car c, int number) {
        customerStock.put(c, number);
    }

    public void receiveBonus(float bonus) {
        buget = buget + bonus;
    }

    public HashMap<Car, Integer> getCustomerStock() {
        return customerStock;
    }

    public void setCustomerStock(HashMap<Car, Integer> customerStock) {
        this.customerStock = customerStock;
    }

    public int getRequest() {
        return request;
    }

    public void setRequest(int request) {
        this.request = request;
    }


}
