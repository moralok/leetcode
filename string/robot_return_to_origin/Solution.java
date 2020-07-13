package string.robot_return_to_origin;

public class Solution {
    
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char ch : moves.toCharArray()) {
            if (ch == 'U') {
                y += 1;
            } else if (ch == 'D') {
                y -= 1;
            } else if (ch == 'L') {
                x -= 1;
            } else if (ch == 'R') {
                x += 1;
            }
        }
        return x == 0 && y == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String case1 = "UD";
        String case2 = "LL";
        System.out.println(solution.judgeCircle(case1));
        System.out.println(solution.judgeCircle(case2));
    }
}