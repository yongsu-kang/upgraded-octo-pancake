import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fail {

    public static void main(String[] args) {

        int n1 = 5;
        int n2 = 4;

        int[] s1 = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] s2 = {4, 4, 4, 4, 4};
        Solution solution = new Solution();

        solution.solution(n1, s1);
        solution.solution(n2, s2);
    }

    private static class Solution {
        public int[] solution(int N, int[] stages) {
            Map<Integer, Double> map = new HashMap<>();

            double[] cnt = new double[N + 2];

            for (int stage : stages) {
                cnt[stage]++;
            }

            double member = stages.length;
            for (int i = 1; i <= N; i++) {
                double count = cnt[i];

                if (count == 0) {
                    map.put(i, 0.0);
                    continue;
                }

                map.put(i, count / member);
                member -= count;
            }

            List<Integer> list = new ArrayList<>(map.keySet());
            Collections.sort(list, (o1, o2) -> Double.compare(map.get(o2), map.get(o1)));

            return list.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
