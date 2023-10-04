// Problem Statement:

// Given an array that contains both negative and positive integers, find the maximum product subarray.

public class solution {
    public static int subarrayWithMaxProduct(int[] arr){
        int n = arr.length;
        int pref = 1;
        int suff = 1;
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            if (pref == 0){
                pref = 1;
            }

            if (suff == 0){
                suff = 1;
            }

            pref = pref * arr[i];
            suff = suff * arr[n-1-i];

            res = Math.max(res, Math.max(pref, suff));
        }

        return res;
    }
}