package daily;

public class Lc0925Solution {
    public boolean isLongPressedName(String name, String typed) {
        // 看到评论里有很多和我的思路一样，但是官方的确实更加清晰
        int i = 0, j = 0;
        while (i < name.length() && j < typed.length()) {
            char ch1 = name.charAt(i);
            char ch2 = typed.charAt(j);
            if (ch1 != ch2) {
                return false;
            }
            int iCount = 0, jCount = 0;
            while (i < name.length() && name.charAt(i) == ch1) {
                i++;
                iCount++;
            }
            while (j < typed.length() && typed.charAt(j) == ch2) {
                j++;
                jCount++;
            }
            if (jCount < iCount) {
                return false;
            }
            // 犯错1：多自增了一次
        }
        // 犯错2：没有考虑好跳出循环后不正确的情形
        if (i != name.length() || j != typed.length()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Lc0925Solution solution = new Lc0925Solution();
        String name = "plpkoh";
        String typed = "plppkkh";
        boolean res = solution.isLongPressedName(name, typed);
        System.out.println(res);
        name = "pyplrz";
        typed = "ppyypllr";
        res = solution.isLongPressedName(name, typed);
        System.out.println(res);
    }
}
