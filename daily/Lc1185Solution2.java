package daily;

import java.time.LocalDateTime;
import java.util.Objects;

public class Lc1185Solution2 {

    private static final int[] daysOfMonth = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    public String dayOfTheWeek(int day, int month, int year) {
        // 天
        int days = day;
        // 月
        for (int i = 0; i < month - 1; i++) {
            days += daysOfMonth[i];
        }
        // 年
        days += 365 * (year - 1971);
        // 闰年
        days += (year - 1969) / 4;
        // 当年是否是闰年
        if ((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) && month >= 3) {
            days++;
        }
        return week[(days + 3) % 7];
    }

    public static void main(String[] args) {
        Lc1185Solution2 solution = new Lc1185Solution2();
        
        int day = 31, month = 8, year = 2019;
        assert solution.dayOfTheWeek(day, month, year).equals("Saturday");

        day = 18;
        month = 7;
        year = 1999;
        assert Objects.equals(solution.dayOfTheWeek(day, month, year), "Sunday");

        day = 15;
        month = 8;
        year = 1993;
        assert Objects.equals(solution.dayOfTheWeek(day, month, year), "Sunday");
    }
}
