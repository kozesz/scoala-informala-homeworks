package ro.scit.evpp;

import java.util.HashMap;

public class Customer {

    private String name;

    private int buget = 66000;
    private HashMap<Car, Integer> customerFleet = new HashMap<>();

    public Customer(String name, int buget) {
        this.name = name;
        this.buget = buget;
    }

    public void buyCar(Car c, int amount) {
        System.out.println("The customer's initial buget is " + getBuget());
        setBuget(getBuget() - (amount * c.getPrice()));
        putCarInFleet(c, amount);
    }

    private void putCarInFleet(Car c, int number) {
        customerFleet.put(c, number);
    }

    public synchronized void receiveBonus(int bonus) {
        setBuget(getBuget() + bonus);
        System.out.println("The customer's buget after receiving the bonus is " + buget);
    }

    public HashMap<Car, Integer> getCustomerFleet() {
        return customerFleet;
    }

    public int getBuget() {
        return buget;
    }

    public void setBuget(int buget) {
        this.buget = buget;
    }
}
