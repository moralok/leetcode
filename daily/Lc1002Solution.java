package daily;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Lc1002Solution {
    
    public List<String> commonChars(String[] A) {
        // 傻乎乎地想到了map
        // 时间复杂度 O(n(M + E)，n为数组长度，M为字符串平均长度，E为字符集长度
        int[] minFrequence = new int[26];
        Arrays.fill(minFrequence, Integer.MAX_VALUE);
        for (String word : A) {
            int[] freq = new int[26];
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                freq[ch - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                minFrequence[i] = Math.min(minFrequence[i], freq[i]);
            }
        }
        List<String> res = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < minFrequence[i]; j++) {
                res.add(String.valueOf((char) (i + 'a')));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Lc1002Solution solution = new Lc1002Solution();
        String[] A = new String[] {"bella","label","roller"};
        System.out.println(solution.commonChars(A));
        A = new String[] {"cool","lock","cook"};
        System.out.println(solution.commonChars(A));
    }
}
