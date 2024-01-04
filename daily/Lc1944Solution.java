package daily;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Lc1944Solution {

    public int[] canSeePersonsCount(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ret = new int[heights.length];
        for (int i = heights.length - 1; i >= 0; i--) {
            int h = heights[i];
            while (!stack.isEmpty() && stack.peek() < h) {
                stack.pop();
                ret[i]++;
            }
            if (!stack.isEmpty()) {
                ret[i]++;
            }
            stack.push(h);
        }
        return ret;
    }

    public static void main(String[] args) {
        Lc1944Solution solution = new Lc1944Solution();

        int[] heights = new int[] {10,6,8,5,11,9};
        assert Arrays.equals(solution.canSeePersonsCount(heights), new int[] {3,1,2,1,1,0});

        heights = new int[] {5,1,2,3,10};
        assert Arrays.equals(solution.canSeePersonsCount(heights), new int[] {4,1,1,1,0});
    }
}
