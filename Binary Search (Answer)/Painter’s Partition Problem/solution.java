// Problem Statement:

// Given an array/list of length ‘N’, where the array/list represents the boards and each element of the given array/list
// represents the length of each board. Some ‘K’ numbers of painters are available to paint these boards.
// Consider that each unit of a board takes 1 unit of time to paint.
// You are supposed to return the area of the minimum time to get this job done of painting all the ‘N’ boards
// under the constraint that any painter will only paint the continuous sections of boards.

import java.util.ArrayList;
import java.util.Collections;

public class solution {
    public static int countPainters(ArrayList<Integer> boards, int time) {
        int n = boards.size();
        int painters = 1;
        long boardsPainter = 0;

        for (int i = 0; i < n; i++) {
            if (boardsPainter + boards.get(i) <= time) {
                boardsPainter += boards.get(i);
            }
            else {
                painters++;
                boardsPainter = boards.get(i);
            }
        }

        return painters;
    }

    public static int findLargestMinDistance(ArrayList<Integer> boards, int k) {
        int low = Collections.max(boards);
        int high = boards.stream().mapToInt(Integer::intValue).sum();

        while (low <= high) {
            int mid = (low + high) / 2;
            int painters = countPainters(boards, mid);

            if (painters > k) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return low;
    }
}