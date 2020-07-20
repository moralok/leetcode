package hash_table.single_number;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.contains(i)) {
                set.add(i);
            } else {
                set.remove(i);
            }
        }

        for (Integer integer : set) {
            return integer;
        }
        return -1;
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        int[] case1 = new int[] {2,2,1};
        int[] case2 = new int[] {4,1,2,1,2};
        System.out.println(singleNumber.singleNumber(case1));;
        System.out.println(singleNumber.singleNumber(case2));;
    }
}