import java.util.HashMap;
import java.util.Map;

public class CollectorDirectory {
    public static void main(String[] args) {
        String word = "AAAAE";

        int solution = solution(word);

        System.out.println("solution = " + solution);

    }

    static Map<String, Integer> directory = new HashMap<>();
    static String[] words = {"A", "E", "I", "O", "U"};
    static int num = 1;
    static StringBuilder sb = new StringBuilder();

    public static int solution(String word) {
        directoryInit( word, 0);
        return directory.get(word);
    }

    private static void directoryInit( String target, int depth) {
        if (depth == 5) {
            return;
        }

        for (String word : words) {
            sb.append(word);
            directory.put(sb.toString(), num++);
            directoryInit(target, depth + 1);

            sb.deleteCharAt(depth);
        }
    }
}
