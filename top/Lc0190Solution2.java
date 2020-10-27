package top;

public class Lc0190Solution2 {
    public int reverseBits(int n) {
        // 分治思想，方法2看不懂
        n = (n >>> 16) | (n << 16);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        return n;
    }

    public static void main(String[] args) {
        Lc0190Solution2 solution = new Lc0190Solution2();
        // 3221225471 (10111111111111111111111111111111) java 中 为 -1073741825
        System.out.println(solution.reverseBits(0b11111111111111111111111111111101)); 
    }
}
