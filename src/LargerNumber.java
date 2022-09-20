public class LargerNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(78);
    }

    private static class Solution {
        public int solution(int n) {

            String s = Integer.toBinaryString(n);

            int nowOneSize = Integer.bitCount(n);

            int answer = n + 1;
            while (true) {

                int nextOneSize = Integer.bitCount(answer);

                if (nowOneSize == nextOneSize) {
                    break;
                }
                answer++;
            }

            return answer;
        }
    }
}
