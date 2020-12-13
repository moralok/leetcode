package top;

import java.util.Random;

public class Lc0384Solution2 {

    private int[] array;
    private int[] original;

    Random random = new Random();
    
    public Lc0384Solution2(int[] nums) {
        // Fisher-Yates
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
        for (int i = 0; i < array.length; i++) {
            swap(i, randomRange(i, array.length));
        }
        return array;
    }

    private void swap(int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private int randomRange(int i, int j) {
        return i + random.nextInt(j - i);
    }
}
