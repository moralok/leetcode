package top;

import java.util.ArrayList;
import java.util.List;

public class Lc0412Solution {
    public List<String> fizzBuzz(int n) {
        // 当映射规则更多时，可以考虑使用映射表进行拼接，减少判断条件
        List<String> ret = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                ret.add("FizzBuzz");
            } else if (i % 3 == 0) {
                ret.add("Fizz");
            } else if (i % 5 == 0) {
                ret.add("Buzz");
            } else {
                ret.add(String.valueOf(i));
            }
        }
        return ret;
    }
}
