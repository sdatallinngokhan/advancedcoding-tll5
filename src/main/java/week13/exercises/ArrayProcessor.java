package week13.exercises;

public class ArrayProcessor {

    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        ArrayProcessor arrayProcessor = new ArrayProcessor();

        int[] arr = {5, 3, 6, 1, 8};
        int[] sortedArr = arrayProcessor.sort(arr);

        System.out.println("Smallest Element : " + sortedArr[0]);
        System.out.println("Biggest Element : " + sortedArr[sortedArr.length - 1]);

        if (sortedArr.length % 2 == 0) {
            System.out.println("1st Middle Element : " + sortedArr[sortedArr.length / 2 - 1]);
            System.out.println("2nd Middle Element : " + sortedArr[sortedArr.length / 2]);
        } else {
            System.out.println("Middle Element : " + sortedArr[sortedArr.length / 2]);
        }
    }
}
