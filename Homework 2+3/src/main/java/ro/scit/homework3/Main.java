package main.java.ro.scit.homework3;


import static main.java.ro.scit.homework3.Homework3.*;
import static main.java.ro.scit.homework3.Sort.bubbleSort;

public class Main {
    /**
     * A company has 4 departments, where each department has 5 sales representatives
     * Initializing the sales representatives by position, name, department, amount of sales and amount of quota
     * Calculating the revenue for each sales representative by multiplying the amount of sales and the amount of quota
     * Using bubble sort, sorting them in a descending order by revenue
     * Using the getTotalSales() method calculating the total sales amount for the entire company
     * Using the getBestSalesRep() method defining the best sales representative, who has the most revenue
     */

    public static void main(String[] args) {
        initSalesRepresentative(0, "Ion", "Roman", 10, 300);
        initSalesRepresentative(1, "Gheorghe", "Roman", 5, 150);
        initSalesRepresentative(2, "Stefan", "Roman", 7, 450);
        initSalesRepresentative(3, "Daniel", "Roman", 3, 500);
        initSalesRepresentative(4, "Alin", "Roman", 12, 200);

        initSalesRepresentative(5, "Janos", "Maghiar", 10, 350);
        initSalesRepresentative(6, "Gyorgy", "Maghiar", 5, 450);
        initSalesRepresentative(7, "Istvan", "Maghiar", 7, 600);
        initSalesRepresentative(8, "Dani", "Maghiar", 3, 150);
        initSalesRepresentative(9, "Alpar", "Maghiar", 12, 250);

        initSalesRepresentative(10, "John", "Englez", 10, 500);
        initSalesRepresentative(11, "George", "Englez", 5, 150);
        initSalesRepresentative(12, "Ivan", "Englez", 7, 300);
        initSalesRepresentative(13, "David", "Englez", 3, 450);
        initSalesRepresentative(14, "Adam", "Englez", 12, 200);

        initSalesRepresentative(15, "Johann", "German", 10, 300);
        initSalesRepresentative(16, "Gottfried", "German", 5, 450);
        initSalesRepresentative(17, "Otto", "German", 7, 350);
        initSalesRepresentative(18, "Derek", "German", 3, 200);
        initSalesRepresentative(19, "Adolf", "German", 12, 600);

        for (int i = 0; i < 20; i++) {
            company[i].revenue = company[i].sales * company[i].quota;
        }

        String names[] = new String[20];
        int rev[] = new int[20];
        for (int i = 0; i < 20; i++) {
            names[i] = company[i].name;
            rev[i] = company[i].revenue;
            System.out.println("The revenue for " + names[i] + " is " + rev[i]);
        }

        bubbleSort(rev, names);
        System.out.println("After Bubble Sort");

        for (int i = 0; i < names.length; i++) {
            System.out.println("The revenue for " + names[i] + " is " + rev[i]);
        }

        SalesRepresentative totalOfSales = getTotalSales();
        System.out.println("Total sales = " + totalOfSales.revenue);

        SalesRepresentative bestOfSales = getBestSalesRep();
        System.out.println("Best sales representative is " + bestOfSales.name + " with a revenue of " + bestOfSales.revenue);

    }


}
