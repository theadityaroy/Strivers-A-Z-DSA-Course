// Problem Statement:

// Given an integer array arr of size N, sorted in ascending order (may contain duplicate values)
// and a target value k. Now the array is rotated at some pivot point unknown to you.
// Return True if k is present and otherwise, return False. 

public class solution {
    public static boolean searchInARotatedSortedArrayII(int []A, int key) {
        int n = A.length;
        int low = 0;
        int high = n - 1;

        while(low <= high) {
            int mid = (low + high)/ 2;

            if(A[mid] == key) {
                return true;
            }

            if(A[low] == A[mid] && A[mid] == A[high]){
                low++;
                high--;
                continue;
            }

            // Checking Left Half
            if(A[low] <= A[mid]) {
                if(A[low] <= key && key <= A[mid]) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }

            // Checking Right Half
            else {
                if(A[mid] <= key && key <= A[high]) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }
        
        return false;
    }
}