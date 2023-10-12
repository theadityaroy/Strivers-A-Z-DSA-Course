// Problem Statement :

// Given a sorted array of N integers,
// write a program to find the index of the first and last occurrence of the target key.
// If the target is not found then return {-1, -1}.

import java.util.ArrayList;

public class solution {
    public static int[] firstAndLastPosition (ArrayList<Integer> arr, int n, int k) {
        int first = firstIdx(arr, n,  k);
        if (first == n || arr.get(first) != k){
            return new int[]{-1, -1};
        }
        
        return new int[] {first, lastIdx(arr, n, k)};
    }

    // First Index :
    public static int firstIdx (ArrayList<Integer> arr, int n, int k){
        int low = 0;
        int high = n-1;
        int res = n;

        while (low <= high){
            int mid = (low + high)/2;

            if (arr.get(mid) >= k){
                res = mid;
                high = mid - 1;
            }

            else {
                low = mid + 1;
            }
        }
        return res;
    }

    // Last Index :
    public static int lastIdx (ArrayList<Integer> arr, int n, int k){
        int low = 0;
        int high = n-1;
        int res = n;

        while (low <= high){
            int mid = (low + high)/2;

            if (arr.get(mid) > k){
                res = mid;
                high = mid - 1;
            }

            else {
                low = mid + 1;
            }
        }
        return res - 1;
    }
}
