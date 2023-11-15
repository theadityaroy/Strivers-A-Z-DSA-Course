// Problem Statement:

// You are given an array of integers ‘arr’ and an integer i.e. a threshold value ‘limit’.
// Your task is to find the smallest positive integer divisor, such that upon dividing all the elements of the given array by it,
// the sum of the division’s result is less than or equal to the given threshold value.

public class solution {
    public static int smallestDivisor(int arr[], int limit) {
        int n = arr.length;

        if (n > limit) {
            return -1;
        }

        int low = 1;
        int high = maxElement(arr);
        int res = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (isDivisor(arr, limit, mid)) {
                res = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return res;
    }

    public static int maxElement(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int i : arr) {
            max = Math.max(max, i);
        }

        return max;
    }

    public static boolean isDivisor(int[] arr, int limit, int div) {
        int sum = 0;

        for (int i : arr) {
            sum += Math.ceil((double) i / (double) div);
        }

        return sum <= limit;
    }
}