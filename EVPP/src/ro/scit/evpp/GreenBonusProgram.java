package ro.scit.evpp;

import java.util.HashMap;

public class GreenBonusProgram {

    private int buget = 19000;
    private HashMap<Customer, Car> history = new HashMap<>();

    private int getBuget() { return buget; }

    public void setBuget(int buget) {
        this.buget = buget;
    }

    public GreenBonusProgram() {
        this.buget = buget;
    }

    public int giveGreenBonus(Customer customer, Car c, int amount) {
        int bonus = 0;
        if (getBuget() >= (10000 * amount)) {
            bonus = amount * 10000;
            buget = (buget - bonus);
            history.put(customer, c);
            System.out.println("Congratulations, you got the bonus of " + bonus);
        } else {
            if (getBuget() >= 10000) {
                bonus = (int) (10000 * Math.max(1, Math.floor(buget / 10000)));
                buget = (buget - bonus);
                history.put(customer, c);
                System.out.println("Congratulations, you got the bonus of " + bonus);
            } else {
                System.out.println("There is not buget left.");
            }
        }
        return bonus;
    }

}
