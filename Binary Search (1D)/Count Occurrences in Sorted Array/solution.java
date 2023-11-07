// Problem Statement:

// You are given a sorted array containing N integers and a number X,
// You have to find the occurrences of X in the given array.

public class solution {
    public static int count(int[] arr, int n, int x) {
        int first = firstIdx(arr, n, x);
        if(first == -1){
            return 0;
        }
        return (lastIdx(arr, n, x) - first) + 1;
    }
    public static int firstIdx(int[] arr, int n, int k){
        int low = 0;
        int high = n-1;
        int first = -1;
        
        while(low <= high){
            int mid = (low + high)/2;
            
            if(arr[mid] == k){
                first = mid;
                high = mid - 1;
            }
            else if(arr[mid] < k){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return first;
    }
    public static int lastIdx(int[] arr, int n, int k){
        int low = 0;
        int high = n-1;
        int last = -1;
        
        while(low <= high){
            int mid = (low + high)/2;
            
            if(arr[mid] == k){
                last = mid;
                low = mid + 1;
            }
            else if(arr[mid] < k){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return last;
    }
}