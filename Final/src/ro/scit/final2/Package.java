package ro.scit.final2;

import java.util.Comparator;

public class Package {

    private String myTargetLocation;
    private int distanceToTarget;
    private int merchandiseValue;
    private String myDeliveryDate; //dd.mm.yyyy

    public static Comparator<Package> targetLocation = (Package o1, Package o2) -> {
        String targetLocation1 = o1.getMyTargetLocation();
        String targetLocation2 = o2.getMyTargetLocation();
        return targetLocation1.compareTo(targetLocation2);
    };

    public static Comparator<Package> deliveryDate = (o1, o2) -> {
        String deliveryDate1 = o1.getMyDeliveryDate();
        String deliveryDate2 = o2.getMyDeliveryDate();
        return deliveryDate1.compareTo(deliveryDate2);

    };

    public Package(String myTargetLocation, int distanceToTarget, int merchandiseValue, String myDeliveryDate) {
        this.myTargetLocation = myTargetLocation;
        this.distanceToTarget = distanceToTarget;
        this.merchandiseValue = merchandiseValue;
        this.myDeliveryDate = myDeliveryDate;
    }

    public int getDistanceToTarget() {
        return distanceToTarget;
    }

    public void setDistanceToTarget(int distanceToTarget) {
        this.distanceToTarget = distanceToTarget;
    }

    public int getMerchandiseValue() {
        return merchandiseValue;
    }

    public void setMerchandiseValue(int merchandiseValue) {
        this.merchandiseValue = merchandiseValue;
    }


    public String getMyTargetLocation() {
        return myTargetLocation;
    }

    public void setMyTargetLocation(String myTargetLocation) {
        this.myTargetLocation = myTargetLocation;
    }

    public String getMyDeliveryDate() {
        return myDeliveryDate;
    }

    public void setMyDeliveryDate(String myDeliveryDate) {
        this.myDeliveryDate = myDeliveryDate;
    }

    @Override
    public String toString() {
        return "Package{" +
                "myTargetLocation='" + myTargetLocation + '\'' +
                ", distanceToTarget=" + distanceToTarget +
                ", merchandiseValue=" + merchandiseValue +
                ", myDeliveryDate='" + myDeliveryDate + '\'' +
                '}'+ '\n' ;
    }
}
