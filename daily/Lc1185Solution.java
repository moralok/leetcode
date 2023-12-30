package daily;

import java.time.LocalDateTime;
import java.util.Objects;

public class Lc1185Solution {

    public String dayOfTheWeek(int day, int month, int year) {
        LocalDateTime localDateTime = LocalDateTime.of(year, month, day, 0, 0);
        String dayOfWeek = localDateTime.getDayOfWeek().toString();
        return dayOfWeek.substring(0, 1) + dayOfWeek.substring(1).toLowerCase();
    }

    public static void main(String[] args) {
        Lc1185Solution solution = new Lc1185Solution();

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
