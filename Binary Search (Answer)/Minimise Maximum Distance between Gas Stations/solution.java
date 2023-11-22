// Problem Statement:

// You are given a sorted array ‘arr’ of length ‘n’, which contains positive integer positions of ‘n’ gas stations on the X-axis.
// You are also given an integer ‘k’. You have to place ‘k’ new gas stations on the X-axis.
// You can place them anywhere on the non-negative side of the X-axis, even on non-integer positions.
// Let ‘dist’ be the maximum value of the distance between adjacent gas stations after adding k new gas stations.
// Find the minimum value of ‘dist’.

public class solution {
    public static double MinimiseMaxDistance(int []arr, int K){
        double low = 0;
        double high = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            high = Math.max(high, (double) (arr[i + 1] - arr[i]));
        }

        double diff = 1e-6;

        while (high - low > diff) {
            double mid = (low + high) / 2.0;
            int cnt = numberOfGasStationsRequired(mid, arr);

            if (cnt > K) {
                low = mid;
            }
            else {
                high = mid;
            }
        }

        return high;
    }

    private static int numberOfGasStationsRequired(double dist, int[] arr) {
        int n = arr.length;
        int cnt = 0;

        for (int i = 1; i < n; i++) {
            int numberInBetween = (int) ((arr[i] - arr[i - 1]) / dist);

            if ((arr[i] - arr[i - 1]) == (dist * numberInBetween)) {
                numberInBetween--;
            }

            cnt += numberInBetween;
        }

        return cnt;
    }
}