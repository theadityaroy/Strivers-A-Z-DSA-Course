// Problem Statement:

// You’re given an sorted array arr of n integers and an integer x. Find the floor and ceiling of x in arr[0..n-1].
// The floor of x is the largest element in the array which is smaller than or equal to x.
// The ceiling of x is the smallest element in the array greater than or equal to x.

public class solution {
    public static int ceilingInSortedArray(int n, int x, int[] arr) {
        findFloor(arr, n, x);
        return findCeil(arr, n, x);
    }
    public static void findFloor(int[] arr, int n, int x) {
        int low = 0;
        int high = n-1;
        int res = -1;

        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] <= x){
                res = arr[mid];
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }  
        System.out.print(res + " ");
    }

    public static int findCeil(int[] arr, int n, int x) {
        int low = 0;
        int high = n-1;
        int res = -1;

        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] >= x){
                res = arr[mid];
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }  
        return res; 
    }
}