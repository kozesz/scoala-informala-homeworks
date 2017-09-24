package main.java.ro.scit.homework3;

public class Homework3 {

    static SalesRepresentative[] company = new SalesRepresentative[20];

    public static void initSalesRepresentative(int position, String name, String department, int sales, int quota) {
        /**
         * Initializing Sales Representative objects.
         * Using position, name, department name, amount of sales and amount of quota.
         */
        company[position] = new SalesRepresentative();
        company[position].department = department;
        company[position].name = name;
        company[position].sales = sales;
        company[position].quota = quota;
    }

    public static SalesRepresentative getTotalSales() {
        /**
         * Returns total sales per company.
         */
        SalesRepresentative totalSales = new SalesRepresentative();
        totalSales.revenue = 0;
        for (SalesRepresentative member : company) {
            totalSales.revenue = totalSales.revenue + member.revenue;
        }
        return totalSales;
    }

    public static SalesRepresentative getBestSalesRep() {
        /**
         * Returns the sales representative with the most revenue, where revenue equals the multiplication of sales and quota.
         */
        SalesRepresentative bestSalesRep = new SalesRepresentative();
        bestSalesRep.revenue = 0;
        bestSalesRep.name = "";

        for (SalesRepresentative member : company) {
            if (member.revenue > bestSalesRep.revenue) {
                bestSalesRep.revenue = member.revenue;
                bestSalesRep.name = member.name;
            }
        }
        return bestSalesRep;
    }

    public static int bestDepartment() {
        /**
         * Calculates the total revenue per department.
         */
        int[] sum = new int[4];
        String[] bestDep = new String[]{"Roman", "Maghiar", "Englez", "German"};
        for (int i = 0; i < 5; i++) {
            sum[0] = sum[0] + company[i].revenue;
        }

        for (int i = 5; i < 10; i++) {
            sum[1] = sum[1] + company[i].revenue;
        }

        for (int i = 10; i < 15; i++) {
            sum[2] = sum[2] + company[i].revenue;
        }

        for (int i = 15; i < 20; i++) {
            sum[3] = sum[3] + company[i].revenue;
        }

        int max = 0;
        int index = 0;
        for (int i = 0; i < 4; i++) {
            if (sum[i] > max) {
                max = sum[i];
                index = i;
            }
        }
        System.out.println("The " + bestDep[index] + " department has the most revenue, in total " + max);
        return max;
    }

}
