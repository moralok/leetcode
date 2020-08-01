package sort.largest_number;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        String ret = IntStream.of(nums).mapToObj(String::valueOf).sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2)).collect(Collectors.joining());
        return ret.startsWith("0") ? "0" : ret;
    }
}