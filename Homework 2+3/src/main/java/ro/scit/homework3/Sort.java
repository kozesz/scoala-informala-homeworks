package main.java.ro.scit.homework3;

public class Sort {
    static void bubbleSort(int[] arr, String[] name) {
        /**
         * Sorting the sales representatives in a descending order by revenue.
         */

        int n = arr.length;
        boolean swapped = true;
        int i, temp = 0;
        int j = 0;
        String temporary = "";

        while (swapped) {
            swapped = false;
            j++;
            for (i = 0; i < n - j; i++) {
                if (arr[i] < arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;

                    temporary = name[j - 1];
                    name[j - 1] = name[j];
                    name[j] = temporary;

                    swapped = true;
                }
            }
        }
    }
}