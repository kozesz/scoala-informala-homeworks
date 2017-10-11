package ro.scit.evpp;

public class GreenBonusProgram {

    private float buget;

    public float getBuget() {
        return buget;
    }

    public void setBuget(float bugetProgram) {
        this.buget = buget;
    }

    public float giveGreenBonus(Car c, int amount) {
        float bonus = 0;
        if (buget >= (amount * 10000)) {
            bonus = amount * 10000;
            buget = (buget - bonus);
        } else {
            System.out.println("There is no buget left.");
            bonus = 0;
        }
        return bonus;
    }

    public GreenBonusProgram(float buget) {
        this.buget = buget;
    }

}
