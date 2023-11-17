// Problem Statement: 

// You are given a strictly increasing array ‘vec’ and a positive integer ‘k’.
// Find the ‘kth’ positive integer missing from ‘vec’.

public class solution {
    public static int missingK(int[] vec, int n, int k) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int missing = vec[mid] - (mid + 1);

            if (missing < k) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        
        return k + high + 1;
    }
}