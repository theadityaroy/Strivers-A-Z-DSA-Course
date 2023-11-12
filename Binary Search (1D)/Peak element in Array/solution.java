// Problem Statement:

// Given an array of length N. Peak element is defined as the element greater than both of its neighbors.
// Formally, if ‘arr[i]’ is the peak element, ‘arr[i – 1]’ < ‘arr[i]’ and ‘arr[i + 1]’ < ‘arr[i]’.
// Find the index(0-based) of a peak element in the array. If there are multiple peak numbers,
// return the index of any peak number.

import java.util.ArrayList;

public class solution {
    public static int findPeakElement(ArrayList<Integer> arr) {
        int n = arr.size();

        if (n == 1) {
            return 0;
        }

        if (arr.get(0) > arr.get(1)) {
            return 0;
        }

        if (arr.get(n - 1) > arr.get(n - 2)) {
            return n - 1;
        }

        int low = 1;
        int high = n - 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr.get(mid - 1) < arr.get(mid) && arr.get(mid) > arr.get(mid + 1)) {
                return mid;
            }

            if (arr.get(mid - 1) < arr.get(mid)) {
                low = mid + 1;
            }
            
            else {
                high = mid - 1;
            }
        }

        return -1;
    }
}