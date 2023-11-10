// Problem Statement:

// Given an integer array arr of size N, sorted in ascending order (with distinct values).
// Now the array is rotated between 1 to N times which is unknown. Find the minimum element in the array. 


public class solution {
    public static int findMin(int []arr) {
        int res = Integer.MAX_VALUE;
        int n = arr.length;

        int low = 0;
        int high = n-1;

        while(low <= high) {
            int mid = (low + high)/2;
            
            if(arr[low] <= arr[mid]) {
                res = Math.min(res, arr[low]);
                low = mid + 1;
            }
            else {
                res = Math.min(res, arr[mid]);
                high = mid - 1;
            }
        }

        return res;
    }
}