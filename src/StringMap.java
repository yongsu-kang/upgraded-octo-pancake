import java.util.*;

public class StringMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Map<String, Object> s = new HashMap<>();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            s.put(sc.next(), null);
        }

        for (int i = 0; i < m; i++) {
            list.add(sc.next());
        }

        int result = 0;
        for (String value : list) {
            if (s.containsKey(value)) {
                result++;
            }
        }

        System.out.println(result);
    }
}
