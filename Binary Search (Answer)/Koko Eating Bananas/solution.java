// Problem Statement:

// A monkey is given ‘n’ piles of bananas, whereas the ‘ith’ pile has ‘a[i]’ bananas.
// An integer ‘h’ is also given, which denotes the time (in hours) for all the bananas to be eaten.

public class solution {
    public static int minimumRateToEatBananas(int[] v, int h) {
        int low = 1;
        int high = findMax(v);

        while (low <= high) {
            int mid = (low + high) / 2;
            int time = findHours(v, mid);

            if (time <= h) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static int findMax(int[] v) {
        int n = v.length;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, v[i]);
        }

        return max;
    }

    public static int findHours(int[] v, int time) {
        int n = v.length;
        int countHours = 0;

        for (int i = 0; i < n; i++) {
            countHours += Math.ceil((double) v[i] / (double) time);
        }

        return countHours;
    }
}