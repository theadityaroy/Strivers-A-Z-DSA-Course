// Problem Statement:

// Given two numbers N and M, find the Nth root of M.
// The nth root of a number M is defined as a number X when raised to the power N equals M.
// If the ‘nth root is not an integer, return -1.

public class solution {
    public static int NthRoot(int n, int m) {
        long low = 1;
        long high = m;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long target = (long) Math.pow(mid, n);

            if (target == m) {
                return (int) mid;
            }
            else if (target > m) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
}