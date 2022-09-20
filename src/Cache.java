import java.util.LinkedList;

public class Cache {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        int size = 3;
        int answer = solution.solution(size, cities);
        System.out.println("answer = " + answer);
    }

    private static class Solution {
        public int solution(int cacheSize, String[] cities) {
            if (cacheSize == 0) {
                return cities.length * 5;
            }

            int answer = 0;

            LinkedList<String> cache = new LinkedList<>();

            for (String city : cities) {
                String s = city.toLowerCase();

                if (cache.remove(s)) {
                    answer += 1;
                    cache.add(s);
                } else {
                    answer += 5;
                    cache.add(s);
                    if (cache.size() > cacheSize) {
                        cache.remove(0);
                    }
                }
            }

            return answer;
        }
    }
}




