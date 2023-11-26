// Problem Statement:

// You have been given a 2-D array ‘mat’ of size ‘N x M’ where ‘N’ and ‘M’ denote the number of rows and columns, respectively.
// The elements of each row are sorted in non-decreasing order.
// Moreover, the first element of a row is greater than the last element of the previous row (if it exists).
// You are given an integer ‘target’, and your task is to find if it exists in the given ‘mat’ or not.

import java.util.ArrayList;

public class solution {
    static boolean searchMatrix(ArrayList<ArrayList<Integer>> matrix, int target) {
        int rows = matrix.size();
        int cols = matrix.get(0).size();

        int low = 0, high = rows * cols - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int midValue = matrix.get(mid / cols).get(mid % cols);

            if (midValue == target) {
                return true;
            }
            else if (midValue < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return false;
    }
}