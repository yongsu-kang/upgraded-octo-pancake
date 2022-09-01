import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringPress {
    public static void main(String[] args) {
        String msg = "KAKAO";

        int[] solution = solution(msg);
    }
    public static int[] solution(String msg) {
        Map<String, Integer> diary = new HashMap<>();
        initDiary(diary);

        List<Integer> list = new ArrayList<>();

        int wordCount = diary.size();
        int location = 0;
        int count = 2;
        while (true) {
            int lastLocation = location + count - 1;
            String substring;

            if (lastLocation <= msg.length()) {
                substring = msg.substring(location, lastLocation);
            } else {
                substring = msg.substring(location);

                Integer integer = diary.get(substring);
                list.add(integer);
                break;
            }

            if (!diary.containsKey(substring)) {
                String key = msg.substring(location, lastLocation - 1);
                System.out.println("key = " + key);
                list.add(diary.get(key));
                diary.put(substring, ++wordCount);

                location += count - 2;
                count = 1;
            }
            count++;
        }

        System.out.println("list = " + list);

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    private static void initDiary(Map<String, Integer> diary) {
        String[] wordS = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        for (int i = 0; i < 26; i++) {
            diary.put(wordS[i], i + 1);
        }
    }
}
