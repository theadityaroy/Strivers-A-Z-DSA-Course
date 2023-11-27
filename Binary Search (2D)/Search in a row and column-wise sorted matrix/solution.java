// Problem Statement:

// You have been given a 2-D array ‘mat’ of size ‘N x M’ where ‘N’ and ‘M’ denote the number of rows and columns, respectively.
// The elements of each row and each column are sorted in non-decreasing order.
// But, the first element of a row is not necessarily greater than the last element of the previous row (if it exists).
// You are given an integer ‘target’, and your task is to find if it exists in the given ‘mat’ or not.

public class solution {
    public static boolean searchElement(int[][] MATRIX, int target) {
        int n = MATRIX.length;
        int m = MATRIX[0].length;
        int row = 0, col = m - 1;

        while (row < n && col >= 0) {
            if (MATRIX[row][col] == target) {
                return true;
            }
            else if (MATRIX[row][col] < target) {
                row++;
            }
            else {
                col--;
            }
        }

        return false;
    }
}