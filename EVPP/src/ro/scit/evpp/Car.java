package ro.scit.evpp;

import java.util.Comparator;

public class Car implements Comparable<Car> {
    private String electricMotor;
    private String electricBattery;
    private String energyConsumption;
    private String manufacturer;
    private String model;
    private int productionYear;
    private boolean isItNew;
    private boolean fastCharge;
    private int horsePower;
    private int price;
    private int rangePerCharge;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (isItNew != car.isItNew) return false;
        if (fastCharge != car.fastCharge) return false;
        if (horsePower != car.horsePower) return false;
        if (Float.compare(car.price, price) != 0) return false;
        if (rangePerCharge != car.rangePerCharge) return false;
        if (!manufacturer.equals(car.manufacturer)) return false;
        return model.equals(car.model);
    }

    @Override
    public int hashCode() {
        int result = manufacturer.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + (isItNew ? 1 : 0);
        result = 31 * result + (fastCharge ? 1 : 0);
        result = 31 * result + horsePower;
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        result = 31 * result + rangePerCharge;
        return result;
    }

    public Car(String manufacturer, String model, boolean fastCharge, int price, int horsePower, int rangePerCharge, boolean isItNew) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.fastCharge = fastCharge;
        this.price = price;
        this.horsePower = horsePower;
        this.rangePerCharge = rangePerCharge;
        this.isItNew = isItNew;
    }

    public static Comparator<Car> priceComparator = (o1, o2) -> {
        int carPrice1 = o1.getPrice();
        int carPrice2 = o2.getPrice();
        return carPrice1 - carPrice2;
    };

    public static Comparator<Car> horsePowerComparator = (o1, o2) -> {
        int horsePower1 = o1.getHorsePower();
        int horsePower2 = o2.getHorsePower();
        return horsePower1 - horsePower2;
    };

    public static Comparator<Car> rangePerChargeComparator = (o1, o2) -> {
        int range1 = o1.getRangePerCharge();
        int range2 = o2.getRangePerCharge();
        return range1 - range2;
    };


    public boolean isItNew() {
        return isItNew;
    }

    public boolean isFastCharge() {
        return fastCharge;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "\nCar{" +
                "manufacturer = '" + manufacturer + '\'' + "," +
                " model = '" + model + '\'' + "," +
                " fastCharge = " + fastCharge + "," +
                " price = " + price + "," +
                " horsepower = " + horsePower + "," +
                " range per charge = " + rangePerCharge + "," +
                " isItNew = " + isItNew +
                '}';
    }

    @Override
    public int compareTo(Car o) {
        if (this.getPrice() > o.getPrice()) {
            return 1;
        } else if (this.getPrice() < o.getPrice()) {
            return -1;
        }
        return 0;
    }

    public int getRangePerCharge() {
        return rangePerCharge;
    }

    public void setRangePerCharge(int rangePerCharge) {
        this.rangePerCharge = rangePerCharge;
    }

}
