package daily;

public class Lc0925Solution2 {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();
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
