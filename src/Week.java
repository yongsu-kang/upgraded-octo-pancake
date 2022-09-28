import java.time.LocalDate;

public class Week {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(5, 22);
    }

    private static class Solution {
        public String solution(int a, int b) {
            String[] week = {"", "MON", "TUE", "WED", "THU", "FRI", "SAT","SUN"};

            LocalDate date = LocalDate.of(2016, a, b);
            int dayOfWeek = date.getDayOfWeek().getValue();

            return week[dayOfWeek];
        }
    }
}
