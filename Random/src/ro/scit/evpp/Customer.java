package ro.scit.evpp;

import java.util.HashMap;

public class Customer {

    private String name;

    private int buget = 16000;
    private HashMap<Car, Integer> customerFleet = new HashMap<>();

    public Customer(String name) {
        this.name = name;
    }

    public void buyCar(Car c, int amount) {
        System.out.println("The customer's initial buget is " + getBuget());
        buget = buget - (amount * c.getPrice());
        putCarInFleet(c, amount);
    }

    private void putCarInFleet(Car c, int number) {
        customerFleet.put(c, number);
    }

    public void receiveBonus(int bonus) {

        buget = buget + bonus;
        System.out.println("The customer's buget after receiving the bonus is " + buget);
    }

    public HashMap<Car, Integer> getCustomerFleet() {
        return customerFleet;
    }

    public float getBuget() {
        return buget;
    }

    public void setBuget(int buget) {
        this.buget = buget;
    }
}
