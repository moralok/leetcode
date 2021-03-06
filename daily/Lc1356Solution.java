package daily;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lc1356Solution {
    public int[] sortByBits(int[] arr) {
        int bit[] = new int[10001];
        List<Integer> list = new ArrayList<>(arr.length);
        for (int i : arr) {
            list.add(i);
            bit[i] = get(i);
        }
        Collections.sort(list, (x, y) -> {
            if (bit[x] != bit[y]) {
                return bit[x] - bit[y];
            } else {
                return x - y;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    private int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 2;
            x /= 2;
        }
        return res;
    }
}
