// Problem Statement:

// You are the owner of a Shipment company. You use conveyor belts to ship packages from one port to another.
// The packages must be shipped within ‘d’ days.
// The weights of the packages are given in an array ‘of weights’.
// The packages are loaded on the conveyor belts every day in the same order as they appear in the array.
// The loaded weights must not exceed the maximum weight capacity of the ship.
// Find out the least-weight capacity so that you can ship all the packages within ‘d’ days.

public class solution {
    public static int leastWeightCapacity(int[] weights, int d) {
        int low = Integer.MIN_VALUE;
        int high = 0;

        for (int i = 0; i < weights.length; i++) {
            high += weights[i];
            low = Math.max(low, weights[i]);
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int numberOfDays = findDays(weights, mid);

            if (numberOfDays <= d) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static int findDays(int[] weights, int cap) {
        int days = 1;
        int load = 0;
        int n = weights.length;

        for (int i = 0; i < n; i++) {
            if (load + weights[i] > cap) {
                days += 1;
                load = weights[i];
            }
            else {
                load += weights[i];
            }
        }

        return days;
    }
}