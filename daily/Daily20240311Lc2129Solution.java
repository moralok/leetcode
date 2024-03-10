package daily;

public class Daily20240311Lc2129Solution {

    public String capitalizeTitle(String title) {
        StringBuilder res = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < title.length(); i++) {
            char c = title.charAt(i);
            if (c == ' ') {
                if (tmp.length() <= 2) {
                    tmp.setCharAt(0, (char) (tmp.charAt(0) + 'a' - 'A'));
                }
                res.append(tmp).append(' ');
                tmp = new StringBuilder();
            } else {
                if (tmp.length() == 0) {
                    if (c >= 'a') {
                        c = (char) (c - 'a' + 'A');
                    }
                } else {
                    if (c < 'a') {
                        c = (char) (c + 'a' - 'A');
                    }
                }
                tmp.append(c);
            }
        }
        if (tmp.length() <= 2) {
            tmp.setCharAt(0, (char) (tmp.charAt(0) + 'a' - 'A'));
        }
        res.append(tmp);
        return res.toString();
    }

    public static void main(String[] args) {
        Daily20240311Lc2129Solution solution = new Daily20240311Lc2129Solution();
        String title = "capiTalIze tHe titLe";
        assert "Capitalize The Title".equals(solution.capitalizeTitle(title));

        title = "First leTTeR of EACH Word";
        assert "First Letter of Each Word".equals(solution.capitalizeTitle(title));

        title = "L hV";
        assert "l hv".equals(solution.capitalizeTitle(title));
    }
}
