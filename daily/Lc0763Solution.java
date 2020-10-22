package daily;

import java.util.LinkedList;
import java.util.List;

public class Lc0763Solution {
    public List<Integer> partitionLabels(String S) {
        // 自我感觉很欣慰，和题解思路一致，但是这个思考和摸索的过程，没啥方法论啊
        // 脑子抽了还记录了最开始
        // 感觉只有小写字母就是为了使用长度为26的数组，不过速度差距这么大吗
        int[] endMap = new int[26];
        for (int i = 0; i < S.length(); i++) {
            endMap[S.charAt(i) - 'a'] = i;
        }
        int i = 0, start = 0, end = 0;
        List<Integer> res = new LinkedList<>();
        while (i < S.length()) {
            char c = S.charAt(i);
            // 更新当前分段的末尾，取当前字符的最后出现位置和当前分段内字符已知的最后出现位置
            end = Math.max(endMap[c - 'a'], end);
            if (i == end) {
                // 如果start追上end，即当前段内的所有字符最后出现的位置都<=end
                res.add(end - start + 1);
                start = end + 1;
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        Lc0763Solution solution = new Lc0763Solution();
        String S = "ababcbacadefegdehijhklij";
        System.out.println(solution.partitionLabels(S));
    }
}
