import java.util.ArrayList;
import java.util.List;

public class EnglishEndLang {
    public static void main(String[] args) {

        Solution solution = new Solution();

        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        int n = 3;
        solution.solution(n, words);
    }

    private static class Solution {
        public int[] solution(int n, String[] words) {
            int[] answer = {0, 0};

            String last = "";
            List<String> list = new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                String word = words[i];

                if (list.contains(word) || !word.startsWith(last)) {
                    answer[0] = i % n + 1;
                    answer[1] = i / n + 1;
                    break;
                } else {
                    list.add(word);
                }

                last = word.substring(word.length() - 1);
            }

            return answer;
        }
    }
}
