// Problem Statement:

// You have been given a non-empty grid ‘mat’ with ‘n’ rows and ‘m’ columns consisting of only 0s and 1s.
// All the rows are sorted in ascending order.
// Your task is to find the index of the row with the maximum number of ones.


import java.util.*;

public class solution {
    public static int rowMaxOnes(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        int cnt_max = 0;
        int index = -1;

        for (int i = 0; i < n; i++) {
            int cnt_ones = m - lowerBound(mat.get(i), m, 1);

            if (cnt_ones > cnt_max) {
                cnt_max = cnt_ones;
                index = i;
            }
        }

        return index;
    }
    
    public static int lowerBound(ArrayList<Integer> arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr.get(mid) >= x) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return ans;
    }
}