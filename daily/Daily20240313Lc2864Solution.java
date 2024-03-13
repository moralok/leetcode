package daily;

public class Daily20240313Lc2864Solution {

    public String maximumOddBinaryNumber(String s) {
        int count0 = 0, count1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                count0++;
            } else {
                count1++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count1 - 1; i++) {
            sb.append('1');
        }
        for (int i = 0; i < count0; i++) {
            sb.append('0');
        }
        sb.append('1');
        return sb.toString();
    }

    public static void main(String[] args) {
        Daily20240313Lc2864Solution solution = new Daily20240313Lc2864Solution();
        assert "001".equals(solution.maximumOddBinaryNumber("010"));
        assert "1001".equals(solution.maximumOddBinaryNumber("0101"));
    }
}
