import java.util.*;

public class PocketMonster {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Map<String, String> nameMap = new HashMap<>();
        Map<String, String> numMap = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String name = sc.next();
            String num = String.valueOf(i);
            nameMap.put(name, num);
            numMap.put(num, name);
        }

        List<String> searches = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            searches.add(sc.next());
        }

        StringBuffer sb = new StringBuffer();

        for (String search : searches) {
            if (numMap.containsKey(search)) {
                sb.append(numMap.get(search) + "\n");
            } else {
                sb.append(nameMap.get(search) + "\n");
            }
        }

        System.out.println(sb);
    }
}
