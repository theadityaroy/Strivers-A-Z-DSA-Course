// Problem Statement:

// You are given a sorted array arr of distinct values and a target value x.
// You need to search for the index of the target value in the array.

// If the value is present in the array, then return its index.
// Otherwise, determine the index where it would be inserted in the array while maintaining the sorted order.

public class solution {
    public static int searchInsert(int [] arr, int m){
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int res = n;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(arr[mid] >= m) {
                res = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return res;
    }
}