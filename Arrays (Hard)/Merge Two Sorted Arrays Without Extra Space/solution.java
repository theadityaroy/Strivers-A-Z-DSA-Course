// Problem statement:

// Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order.
// Merge them in sorted order.
// Modify arr1 so that it contains the first N elements and modify arr2 so that it contains the last M elements.

public class solution {
    public static void merge(long[] arr1, long[] arr2, int n, int m) {
        int len = n + m;
        int gap = (len/2) + (len%2);

        while (gap > 0){
            int left = 0;
            int right = left + gap;
            while (right < len){
                if(left < n && right >= n) {
                    swap(arr1, arr2, left, right - n);
                }

                else if(left >= n) {
                    swap(arr2, arr2, left - n, right - n);
                }
                
                else {
                    swap(arr1, arr1, left, right);
                }

                left++;
                right++;
            }

            if(gap == 1){
                break;
            }

            gap = (gap/2) + (gap%2);
        }
    }

    public static void swap(long[] a, long[] b, int left, int right) {
        if(a[left] > b[right]){
            long temp = a[left];
            a[left] = b[right];
            b[right] = temp;
        }
    }
}