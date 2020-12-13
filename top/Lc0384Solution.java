package top;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lc0384Solution {

    private int[] array;
    private int[] original;

    private Random random = new Random();
    
    public Lc0384Solution(int[] nums) {
        // 暴力法
        array = nums;
        original = nums.clone();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array = original;
        original = original.clone();
        return array;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        List<Integer> aux = getArrayCopy();

        for (int i = 0; i < array.length; i++) {
            int randomIdx = random.nextInt(aux.size());
            array[i] = aux.get(randomIdx);
            // O(n2)
            aux.remove(randomIdx);
        }
        return array;
    }

    private List<Integer> getArrayCopy() {
        List<Integer> list = new ArrayList<>(array.length);
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return list;
    }
}
