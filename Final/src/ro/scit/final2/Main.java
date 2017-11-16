package ro.scit.final2;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        WareHouse wareHouse = new WareHouse();
        ArrayList<Package> todaysList = wareHouse.createBunchByDate("13.11.2017");
        ArrayList<String> todaysLocations = wareHouse.getLocations(todaysList);
        ArrayList<ArrayList<Package>> todaysBunches = new ArrayList<>();

        System.out.println(wareHouse.getAllPackages());

        System.out.println("By delivery date " + '\n' + wareHouse.getPackagesSortedByDate());
        System.out.println("By location " + '\n' + wareHouse.getPackagesSortedByLocation());

        System.out.println("Today's packages " + todaysList);


        for (int i = 0; i < todaysLocations.size(); i++) {
            todaysBunches.add(wareHouse.getBunchByLocation(todaysList, todaysLocations.get(i)));
        }

        System.out.println("Todays' bunches " + todaysBunches);


        for (int i = 0; i < todaysLocations.size(); i++) {
            Thread thisBunch = new Thread(new WareHouse());
            thisBunch.start();
            wareHouse.deliver(todaysBunches.get(i));


        }

    }


}



