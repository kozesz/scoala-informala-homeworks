package ro.scit;

public class smallestNumber {
    public static int smallestNumberOfArray() {
        int[] myArray = new int[]{51, 63, 25, 99, 512, 830, 1, 67};
        int smallNumber = myArray[0];

        for (int i = 1; i < myArray.length; i++){
            if (smallNumber > myArray[i])
                smallNumber = myArray[i];}
        return smallNumber;

    }
}
