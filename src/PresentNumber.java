public class PresentNumber {

    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.solution(15);
    }

    private static class Solution {
        public int solution(int n) {
            int answer = 1;

            for (int i = 1; i <= n / 2; i++) {
                int sum = 0;
                for (int j = i; j < n; j++) {
                    sum += j;

                    if (sum == n) {
                        answer++;
                        break;
                    } else if (sum > n) {
                        break;
                    }
                }
            }
            return answer;
        }
    }
}

