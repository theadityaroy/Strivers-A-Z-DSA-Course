// Problem Statement:

// You are given ‘N’ roses and you are also given an array ‘arr’ where ‘arr[i]’ denotes that the ‘ith’ rose will bloom on the ‘arr[i]th’ day.
// You can only pick already bloomed roses that are adjacent to make a bouquet.
// You are also told that you require exactly ‘k’ adjacent bloomed roses to make a single bouquet.
// Find the minimum number of days required to make at least ‘m’ bouquets each containing ‘k’ roses.
// Return -1 if it is not possible.

public class solution {
    public static int roseGarden(int[] arr, int r, int b) {
        int n = arr.length;
        int res = -1;

        if (n < r * b) {
            return res;
        }

        int low = minElement(arr, n);
        int high = maxElement(arr, n);

        while (low <= high) {
            int mid = (low + high) / 2;

            if (isPossible(arr, mid, r, b)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return res;
    }
    
    public static int minElement(int[] arr, int n) {
        int min = Integer.MAX_VALUE;

        for (int i : arr) {
            min = Math.min(min, i);
        }

        return min;
    }

    public static int maxElement(int[] arr, int n) {
        int max = Integer.MIN_VALUE;

        for (int i : arr) {
            max = Math.max(max, i);
        }

        return max;
    }

    public static boolean isPossible(int[] arr, int day, int r, int b) {
        int count = 0;
        int bloom = 0;

        for (int i : arr) {
            if (i <= day) {
                count++;
            } else {
                bloom += count / r;
                count = 0;
            }
        }
        bloom += count / r;

        return bloom >= b;
    }
}