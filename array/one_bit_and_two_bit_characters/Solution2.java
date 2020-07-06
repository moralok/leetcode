package array.one_bit_and_two_bit_characters;

public class Solution2 {
    public boolean isOneBitCharacter(int[] bits) {
        int i = bits.length - 2;
        while (i >= 0 && bits[i] > 0) {
            i--;
        }
        return (bits.length - i) % 2 == 0;
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