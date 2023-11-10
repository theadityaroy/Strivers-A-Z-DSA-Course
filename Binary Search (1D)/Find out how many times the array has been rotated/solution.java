// Problem Statement:

// Given an integer array arr of size N, sorted in ascending order (with distinct values).
// Now the array is rotated between 1 to N times which is unknown. Find how many times the array has been rotated. 

public class solution {
    public static int findKRotation(int[] arr) {
        int res = Integer.MAX_VALUE;
        int n = arr.length;
        int idx = -1;
        
        int low = 0;
        int high = n-1;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(arr[low] <= arr[high]) {
                if(arr[low] < res) {
                    res = arr[low];
                    idx = low;
                }
                break;
            }

            if(arr[low] <= arr[mid]) {
                if(arr[low] < res) {
                    res = arr[low];
                    idx = low;
                }
                low = mid + 1;
            }
            else {
                if(arr[mid] < res) {
                    res = arr[mid];
                    idx = mid;
                }
                high = mid - 1;
            }
        }
        
        return idx;
    }
}