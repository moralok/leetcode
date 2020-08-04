package lcof.lcof017;

public class Lcof017Solution2 {
    private StringBuilder res;
    private int nine = 0, start, n;
    private char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public  String printNumbers(int n) {
        this.n = n;
        res = new StringBuilder();
        num = new char[n];
        start = n - 1;
        dfs(0);
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    private void dfs(int x) {
        if (x == n) {
            String s = String.valueOf(num).substring(start);
            if (!s.startsWith("0")) {
                res.append(s + ",");
            }
            // 好难想，绕的我头晕
            if ((n - start) == nine) {
                start--;
            }
            return;
        }
        for (char c : loop) {
            if (c == '9') {
                nine++;
            }
            num[x] = c;
            dfs(x + 1);
        }
        nine--;
    }

    public static void main(String[] args) {
        Lcof017Solution2 solution = new Lcof017Solution2();
        System.out.println(solution.printNumbers(2));
    }
}