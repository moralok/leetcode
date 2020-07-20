package hash_table.happy_number;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        // 可能集合非常大
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
            n = getNext(n);
        }
        return true;
    }

    private int getNext(int n) {
        int sum = 0;
        while (n != 0) {
            int d = n % 10;
            n = n / 10;
            sum += (d * d);
        }
        return sum;
    }

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        int case1 = 19;
        int case2 = 116;
        System.out.println(happyNumber.isHappy(case1));
        System.out.println(happyNumber.isHappy(case2));
    }
}