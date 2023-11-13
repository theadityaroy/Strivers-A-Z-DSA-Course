// Problem Statement:

// You are given a positive integer n. Your task is to find and return its square root.
// If ‘n’ is not a perfect square, then return the floor value of ‘sqrt(n)’.

public class solution {
    public static int sqrtN(long N) {
    	long low = 0;
    	long high = N;

    	long ans = -1;

    	while (low <= high) {
        	long mid = (low + high) / 2;

        	if (mid * mid <= N) {
            	ans = mid;
            	low = mid + 1;
        	}
	        else {
            	high = mid - 1;
        	}
    	}
		
		return (int) ans;
	}
}