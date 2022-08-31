import java.util.*;

public class NumCard2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Integer, Integer> nMap = new HashMap<>();
        List<Integer> mList = new ArrayList<>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int putNum = sc.nextInt();
            if (nMap.containsKey(putNum)) {
                Integer value = nMap.get(putNum) + 1;
                nMap.replace(putNum, value);
            } else {
                nMap.put(putNum, 1);
            }
        }

        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            mList.add(sc.nextInt());
        }

        StringBuffer sb = new StringBuffer();

        for (Integer value : mList) {
            if (nMap.containsKey(value)) {
                sb.append(nMap.get(value) + " ");
            } else {
                sb.append("0 ");
            }
        }

        System.out.println(sb);
    }
}
