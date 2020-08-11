package lcof.lcof058_ii;

public class Lcof058IiSolution {
    public String reverseLeftWords(String s, int n) {
        // 白担心会超长
        n = n % s.length();
        return s.substring(n, s.length()) + s.substring(0, n);
    }
}