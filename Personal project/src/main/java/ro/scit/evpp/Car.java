package ro.scit.evpp;

/**
 * Created by Eszter on 8/25/2017
 * Electronic Vehicle class contains all the car's caracteristics.
 */

public class Car {
    private String electricMotor;
    private String electricBattery;
    private String energyConsumption;
    private String manufacturer;
    private String model;
    private int productionYear;
    private boolean isItNew;
    private boolean fastCharge;
    private int horsePower;
    private float price;
    private int stockNumber;

    public String getElectricMotor() {
        return electricMotor;
    }

    public void setElectricMotor(String electricMotor) {
        this.electricMotor = electricMotor;
    }

    public String getElectricBattery() {
        return electricBattery;
    }

    public void setElectricBattery(String electricBattery) {
        this.electricBattery = electricBattery;
    }

    public String getEnergyConsumption() {
        return energyConsumption;
    }

    public void setEnergyConsumption(String energyConsumption) {
        this.energyConsumption = energyConsumption;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public boolean isItNew() {
        return isItNew;
    }

    public void setItNew(boolean itNew) {
        isItNew = itNew;
    }

    public boolean isFastCharge() {
        return fastCharge;
    }

    public void setFastCharge(boolean fastCharge) {
        this.fastCharge = fastCharge;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(int stockNumber) {
        this.stockNumber = stockNumber;
    }

}