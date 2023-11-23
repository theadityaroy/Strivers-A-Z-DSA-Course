// Problem Statement:

// Given two sorted arrays arr1 and arr2 of size m and n respectively, return the median of the two sorted arrays.
// The median is defined as the middle value of a sorted list of numbers.
// In case the length of the list is even, the median is the average of the two middle elements.

public class solution {
    public static double median(int[] a, int[] b) {
    	int m = a.length;
        int n = b.length;

        if (m > n) {
            return median(b, a);
        }

        int leftHalfSize = (m + n + 1) / 2;

        int low = 0;
        int high = m;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = leftHalfSize - partitionX;

            int maxX = (partitionX > 0) ? a[partitionX - 1] : Integer.MIN_VALUE;
            int maxY = (partitionY > 0) ? b[partitionY - 1] : Integer.MIN_VALUE;
            int minX = (partitionX < m) ? a[partitionX] : Integer.MAX_VALUE;
            int minY = (partitionY < n) ? b[partitionY] : Integer.MAX_VALUE;

            if (maxX <= minY && maxY <= minX) {
                if ((m + n) % 2 == 1) {
                    return Math.max(maxX, maxY);
                } else {
                    return ((double) (Math.max(maxX, maxY) + Math.min(minX, minY))) / 2.0;
                }
            } else if (maxX > minY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }

        return 0;
    }
}