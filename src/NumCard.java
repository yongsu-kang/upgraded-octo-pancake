import java.util.*;

public class NumCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Integer, Object> nMap = new HashMap<>();
        List<Integer> mList = new ArrayList<>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            nMap.put(sc.nextInt(), null);
        }

        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            mList.add(sc.nextInt());
        }

        StringBuffer sb = new StringBuffer();

        for (Integer value : mList) {
            if (nMap.containsKey(value)) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }

        System.out.println(sb);
    }
}
