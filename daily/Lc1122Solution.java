package daily;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Lc1122Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>(arr2.length);
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], 0);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            if (map.containsKey(arr1[i])) {
                map.put(arr1[i], map.get(arr1[i]) + 1);
            } else {
                list.add(arr1[i]);
            }
        }
        Collections.sort(list);
        int i = 0;
        for (int j = 0; j < arr2.length; j++) {
            int count = map.get(arr2[j]);
            while (count-- > 0) {
                arr1[i++] = arr2[j];
            }
        }
        for (Integer integer : list) {
            arr1[i++] = integer;
        }
        return arr1;
    }
}