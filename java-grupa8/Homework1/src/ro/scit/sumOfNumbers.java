package ro.scit;

public class sumOfNumbers {
    public static int sumNumbers100 (int number) {
        int sum = 0;

        for (int i = 0; i < number; i++)
            sum = sum + i;

        return sum;
    }
}
