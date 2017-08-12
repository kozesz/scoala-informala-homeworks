package ro.scit;

import java.util.Scanner;

public class maxDigit {
    public static int maxDigitOfNumber(){
        int maxDigit = 0;
        int nextDigit = 0;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int myNumber = input.nextInt();

        maxDigit = myNumber % 10;

        while (myNumber > 0) {
            myNumber = myNumber / 10;
            nextDigit = myNumber % 10;
            if (maxDigit < nextDigit)
                maxDigit = nextDigit;
        }
        return maxDigit;
    }
}
