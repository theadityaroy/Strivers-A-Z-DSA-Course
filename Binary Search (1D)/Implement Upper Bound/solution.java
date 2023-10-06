// Problem Statement:

// Given a sorted array of N integers and an integer x, write a program to find the upper bound of x.

public class solution {
    public static int upperBound(int []arr, int x, int n){
        int low = 0;
        int high = n - 1;
        int res = n;

        while (low <= high){
            int mid = (low + high) / 2;

            if (arr[mid] > x) {
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
