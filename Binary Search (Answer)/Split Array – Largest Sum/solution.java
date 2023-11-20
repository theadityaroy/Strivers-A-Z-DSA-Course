// Problem Statement:

// Given an integer array ‘A’ of size ‘N’ and an integer ‘K’.
// Split the array ‘A’ into ‘K’ non-empty subarrays such that the largest sum of any subarray is minimized.
// Your task is to return the minimized largest sum of the split.
// A subarray is a contiguous part of the array.

public class solution {
    public static int largestSubarraySumMinimized(int[] a, int k) {
        int low = a[0];
        int high = 0;

        for (int i = 0; i < a.length; i++) {
            low = Math.max(low, a[i]);
            high += a[i];
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int partitions = countPartitions(a, mid);

            if (partitions > k) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return low;
    }
    
    public static int countPartitions(int[] a, int maxSum) {
        int n = a.length;
        int partitions = 1;
        long subarraySum = 0;

        for (int i = 0; i < n; i++) {
            if (subarraySum + a[i] <= maxSum) {
                subarraySum += a[i];
            }
            else {
                partitions++;
                subarraySum = a[i];
            }
        }

        return partitions;
    }
}