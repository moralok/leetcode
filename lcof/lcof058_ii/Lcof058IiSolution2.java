package lcof.lcof058_ii;

public class Lcof058IiSolution2 {
    public String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = n; i < n + s.length(); i++) {
            // 求余巧妙
            res.append(s.charAt(i % s.length()));
        }
        return res.toString();
    }
}