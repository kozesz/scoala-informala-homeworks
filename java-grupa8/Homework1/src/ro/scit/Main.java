package ro.scit;

import java.util.Scanner;

import static ro.scit.maxDigit.maxDigitOfNumber;
import static ro.scit.smallestNumber.smallestNumberOfArray;
import static ro.scit.sumOfNumbers.sumNumbers100;
import static ro.scit.primeNumbers.isPrime;
import static ro.scit.checkPalindrome.isPalindrome;

public class Main {

    public static void main(String[] args) {

        int sum = sumNumbers100(100);

        System.out.println("The sum of the first 100 numbers is " + sum);

        int myNumber = smallestNumberOfArray();
        System.out.println("The smallest number of the array is " + myNumber);

        int max = maxDigitOfNumber();

        System.out.println("The max digit of the number is " + max);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int numberToCheck = scanner.nextInt();

        if (isPalindrome(numberToCheck)) {
        System.out.println("The " + numberToCheck + " is a palindrome");
         } else {
         System.out.println("The " + numberToCheck + " is NOT a palindrome");
         }

        Scanner abc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int givenNumber = abc.nextInt();



        for (int j = 2; j < givenNumber; j++) {
            if (isPrime(j))
                System.out.println(j);}


    }


}







