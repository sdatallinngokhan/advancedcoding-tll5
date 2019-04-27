package week13.exercises;

import java.util.HashSet;
import java.util.Set;

public class ArrayComparor {

    public static void main(String[] args) {
        int[] arr1 = {3, 6, 14, 2, 98, 3};
        int[] arr2 = {32, 16, 4, 6, 3, 5, 52, 109, 14};

        Set<Integer> commonElements = new HashSet<>();
        for (int number1 : arr1) {
            for (int number2 : arr2) {
                if (number1 == number2) {
                    commonElements.add(number1);
                }
            }
        }

        for (int number : commonElements) {
            System.out.print(number + ", ");
        }
    }
}
