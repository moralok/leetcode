package daily;

import java.util.ArrayList;
import java.util.List;

public class Lc0118Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> e = new ArrayList<>();
            e.add(1);
            if (i > 0) {
                List<Integer> pre = ret.get(i-1);
                for (int j = 0; j < pre.size() - 1; j++) {
                    e.add(pre.get(j) + pre.get(j+1));
                }
                e.add(1);
            }
            ret.add(e);
        }
        return ret;
    }
}
