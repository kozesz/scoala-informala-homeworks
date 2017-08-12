package ro.scit;

public class checkPalindrome {
    public static boolean isPalindrome(int numberToCheck) {
        int palindrome = numberToCheck;
        int reverse = 0;

        while (palindrome != 0) {
            int remainder = palindrome % 10;
            reverse = reverse * 10 + remainder;
            palindrome = palindrome / 10;
        }

        if (numberToCheck == reverse) {
            return true;
        }
        return false;
    }
}
