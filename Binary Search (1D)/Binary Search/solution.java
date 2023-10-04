// Problem Statement:

// This is the very first article of the Binary Search series.
// Until now, we have learned the linear search algorithm.
// Now, in this article, we will discuss another search algorithm i.e. the Binary Search algorithm.
// The flow of this article will be the following

public class solution {

    // Iterative Approach:
    public static int search(int []nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if (nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;

        // Recursive Return:
        // return binarySearch(nums, 0, nums.length - 1, target);
    }


    // Recursive Approach:
    public static int binarySearch(int[] nums, int low, int high, int target) {
        if (low > high){
            return -1;
        }
        int mid = (low + high) / 2;
        if (nums[mid] == target){
            return mid;
        }
        else if (target > nums[mid]){
            return binarySearch(nums, mid + 1, high, target);
        }
        return binarySearch(nums, low, mid - 1, target);
    }
}