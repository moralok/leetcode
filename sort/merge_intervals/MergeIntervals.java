package sort.merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> ret = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            return ret.toArray(new int[0][]);
        }
        // 要先排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int i = 0;
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i + 1 < intervals.length && intervals[i + 1][0] <= right) {
                right = Math.max(right, intervals[i + 1][1]);
                i++;
            }
            ret.add(new int[] {left, right});
            i++;
        }
        return ret.toArray(new int[ret.size()][]);
    }
}