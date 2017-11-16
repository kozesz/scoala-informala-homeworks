package ro.scit.final2;

import java.util.ArrayList;
import java.util.Collections;

public class WareHouse implements Runnable {

    ArrayList<String> locations = new ArrayList<>();


    Package packages[] = new Package[]{

            new Package("Turda", 100, 60, "11.11.2017"),
            new Package("Turda", 100, 50, "10.11.2017"),
            new Package("Deva", 200, 60, "13.11.2017"),
            new Package("Deva", 200, 70, "11.11.2017"),
            new Package("Deva", 200, 90, "13.11.2017"),
            new Package("Cluj Napoca", 150, 50, "13.11.2017"),
            new Package("Cluj Napoca", 150, 20, "10.11.2017"),
            new Package("Cluj Napoca", 150, 10, "13.11.2017"),
            new Package("Cluj Napoca", 150, 70, "13.11.2017"),
            new Package("Apahida", 50, 50, "13.11.2017"),
            new Package("Gherla", 70, 20, "10.11.2017"),

    };

    public ArrayList<Package> getAllPackages() {
        ArrayList<Package> allPackages = new ArrayList<>();
        for (Package p : packages) {
            allPackages.add(p);
        }
        return allPackages;
    }

    public ArrayList<Package> getPackagesSortedByLocation() {
        ArrayList sorted = new ArrayList(getAllPackages());
        Collections.sort(sorted, Package.targetLocation);
        return sorted;
    }


    public ArrayList<Package> getPackagesSortedByDate() {
        ArrayList sorted = new ArrayList(getAllPackages());
        Collections.sort(sorted, Package.deliveryDate);
        return sorted;
    }


    public ArrayList<Package> getBunchByLocation(ArrayList<Package> list, String location) {
        ArrayList<Package> thisList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (location == list.get(i).getMyTargetLocation())
                thisList.add(list.get(i));
        }
        return thisList;
    }

    public ArrayList<Package> createBunchByDate(String date) {
        ArrayList thisList = new ArrayList();
        for (int i = 0; i < getAllPackages().size(); i++) {
            if (date == getAllPackages().get(i).getMyDeliveryDate())
                thisList.add(getAllPackages().get(i));
        }

        return thisList;
    }

    public void deliver(ArrayList<Package> bunch) {
        int mv = 0;
        int profit = 0;
        System.out.println("Delivering this ");
        for (int i = 0; i < bunch.size(); i++) {
            mv = mv + bunch.get(i).getMerchandiseValue();
            profit = (profit + (bunch.get(i).getMerchandiseValue() * bunch.get(i).getDistanceToTarget()));
        }
        System.out.println("MerchandiseValue = " + mv);
        System.out.println("Profit = " + profit);

    }

    public ArrayList<String> getLocations(ArrayList<Package> list) {
        for (int i = 0; i < list.size(); i++) {
            if (!locations.contains(list.get(i).getMyTargetLocation())) {
                locations.add(list.get(i).getMyTargetLocation());
            }
        }
        return locations;
    }


    @Override
    public void run() {
        System.out.println("Delivering");

    }


}
