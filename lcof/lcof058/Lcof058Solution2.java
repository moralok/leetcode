package lcof.lcof058;

public class Lcof058Solution2 {
    
    public String reverseWords(String s) {
        // 库函数
        String[] list = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = list.length - 1; i >= 0; i--) {
            if (list[i].equals("")) {
                continue;
            }
            sb.append(list[i]).append(" ");
        }
        return sb.toString().trim();
    }
}