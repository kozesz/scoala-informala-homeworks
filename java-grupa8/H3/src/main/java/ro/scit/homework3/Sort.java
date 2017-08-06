package main.java.ro.scit.homework3;

public class Sort {
    static void bubbleSort(int[] arr, String[] name) {
        /**
         * Bubblesorting the sales representatives using two arrays (names and revenues)
         */

        int n = arr.length;
        int temp = 0;
        String temporary = "";
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] < arr[j]) {

                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;

                    temporary = name[j - 1];
                    name[j - 1] = name[j];
                    name[j] = temporary;
                }

            }
        }
    }
}