import java.util.HashMap;
import java.util.Map;

public class MBTI {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};

        solution.solution(survey, choices);
    }

    private static class Solution {
        public String solution(String[] survey, int[] choices) {
            StringBuilder answer = new StringBuilder();

            Map<String, Integer> map = new HashMap<>();
            map.put("R", 0);
            map.put("T", 0);
            map.put("C", 0);
            map.put("F", 0);
            map.put("J", 0);
            map.put("M", 0);
            map.put("A", 0);
            map.put("N", 0);

            for (int i = 0; i < survey.length; i++) {
                int choice = choices[i];
                int value = choice - 4;

                String[] split = survey[i].split("");
                if (value < 0) {
                    String key = split[0];
                    map.replace(key, map.get(key) + (value * -1));
                } else {
                    String key = split[1];
                    map.replace(key, map.get(key) + value);
                }
            }
            Integer r = map.get("R");
            Integer t = map.get("T");

            if (t > r) {
                answer.append("T");
            } else
                answer.append("R");

            Integer c = map.get("C");
            Integer f = map.get("F");

            if (f > c) {
                answer.append("F");
            } else
                answer.append("C");
            Integer j = map.get("J");
            Integer m = map.get("M");

            if (m > j) {
                answer.append("M");
            } else
                answer.append("J");

            Integer a = map.get("A");
            Integer n = map.get("N");

            if (n > a) {
                answer.append("N");
            } else
                answer.append("A");

            return answer.toString();
        }
    }
}
