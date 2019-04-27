package week13.exercises;

public class LCMFinder {

    public int getLCM(int[] arr) {
        int LCM = 1;
        int primeCandidate = 2;

        while (true) {
            if (isPrime(primeCandidate)) {
                boolean shouldLCMBeMultiplied = false;
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] % primeCandidate == 0) {
                        arr[i] /= primeCandidate; // element = element / primeCandidate;
                        shouldLCMBeMultiplied = true;
                    }
                }

                if (shouldLCMBeMultiplied) {
                    LCM *= primeCandidate;
                }
            }

            boolean shouldPrimeCandidateIsIncreased = true;
            for (int element : arr) {
                if (element % primeCandidate == 0) {
                    shouldPrimeCandidateIsIncreased = false;
                    break;
                }
            }

            if (shouldPrimeCandidateIsIncreased) {
                primeCandidate++;
            }

            boolean areAll1 = true;

            for (int element : arr) {
                if (element != 1) {
                    areAll1 = false;
                    break;
                }
            }

            if (areAll1) {
                break;
            }
        }

        return LCM;
    }

    private boolean isPrime(int number) {
        int counter = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                counter++;
            }
        }

        if (counter == 2) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        LCMFinder lcmFinder = new LCMFinder();

        int[] arr = {12, 15, 44, 4, 5};
        int result = lcmFinder.getLCM(arr);
        System.out.println(result);
    }
}
