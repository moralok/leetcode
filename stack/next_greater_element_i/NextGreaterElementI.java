package stack.next_greater_element_i;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 单调栈，厉害
        Map<Integer, Integer> map = new HashMap<>();
        LinkedList<Integer> stack = new LinkedList<>();
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }
        for (int j = 0; j < nums1.length; j++) {
            res[j] = map.get(nums1[j]);
        }
        return res;
    }
}