package daily;

public class Daily20240410Lc1702Solution {

    public String maximumBinaryString(String binary) {
        int n = binary.length();
        char[] chars = binary.toCharArray();
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] == '0') {
                while (j <= i || (j < n && chars[j] == '1')) {
                    j++;
                }
                if (j < n) {
                    chars[j] = '1';
                    chars[i] = '1';
                    chars[i + 1] = '0';
                }
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Daily20240410Lc1702Solution solution = new Daily20240410Lc1702Solution();
        String binary = "000110";
        assert solution.maximumBinaryString(binary).equals("111011");
    }
}
