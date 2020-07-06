package array.one_bit_and_two_bit_characters;

public class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            if (bits[i] == 0) {
                i++;
            } else {
                i = i + 2;
            }
        }
        return i == bits.length - 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] bits = new int[] {1, 0, 0};
        boolean res = solution.isOneBitCharacter(bits);
        System.out.println(res);
        bits = new int[] {1, 1, 1, 0};
        res = solution.isOneBitCharacter(bits);
        System.out.println(res);
    }
}