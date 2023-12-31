package daily;

public class Lc1154Solution {

    private static final int[] daysOfMonth = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int dayOfYear(String date) {
        String[] split = date.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int days = Integer.parseInt(split[2]);
        for (int i = 0; i < month - 1; i++) {
            days += daysOfMonth[i];
        }
        if ((year % 400 == 0 || year % 4 == 0 && year % 100 != 0) && month >= 3) {
            days++;
        }
        return days;
    }

    public static void main(String[] args) {
        Lc1154Solution solution = new Lc1154Solution();
        String date = "2019-01-09";
        assert solution.dayOfYear(date) == 9;

        date = "2019-02-10";
        assert solution.dayOfYear(date) == 41;
    }
}
