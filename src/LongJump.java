public class LongJump {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(5);
    }

    private static class Solution {
        public long solution(int n) {
            long answer = 0;

            long[] arr = new long[2001];

            arr[1] = 1;
            arr[2] = 2;

            for (int i = 3; i < arr.length; i++) {
                arr[i] = (arr[i - 2] + arr[i - 1]) % 1234567;
            }

            return arr[n];
        }
    }
}


