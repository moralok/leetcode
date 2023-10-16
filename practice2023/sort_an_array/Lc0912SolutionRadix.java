package practice2023.sort_an_array;

import java.util.Arrays;

public class Lc0912SolutionRadix {
    
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        // 基数
        int base = 10;
        int[] aux = new int[len];
        int[] counts = new int[base];

        // 找最小值，避免负数的影响
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            min = Math.min(min, nums[i]);
        }
        
        // 找最大值，求 bits
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            nums[i] -= min;
            max = Math.max(max, nums[i]);
        }
        int bits = 0;
        while (max > 0) {
            max /= base;
            bits++;
        }

        sort(nums, aux, counts, base, bits);

        // 恢复负数的影响
        for (int i = 0; i < len; i++) {
            nums[i] += min;
        }

        return nums;
    }

    private int[] sort(int[] nums, int[] aux, int[] counts, int base, int bits) {
        int len = nums.length;
        int step = 1;
        for (; bits > 0; bits--) {
            // 初始化
            Arrays.fill(counts, 0);
            // 计数
            for (int i = 0; i < len; i++) {
                counts[(nums[i] / step) % base]++;
            }
            // 前缀区间
            for (int i = 1; i < base; i++) {
                counts[i] = counts[i - 1] + counts[i];
            }
            // 从右到左，赋值到辅助数组
            for (int i = len - 1; i >= 0; i--) {
                aux[--counts[(nums[i] / step) % base]] = nums[i];
            }
            for (int i = 0; i < len; i++) {
                nums[i] = aux[i];
            }
            step *= base;
        }
        return nums;
    }

    public static void main(String[] args) {
        // int[] nums = new int[] {5,2,3,1};
        int[] nums = new int[] {3, -1};
        Lc0912SolutionRadix lc0912Solution = new Lc0912SolutionRadix();
        lc0912Solution.sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }
}
