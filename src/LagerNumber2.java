public class LagerNumber2 {
    public static void main(String[] args) {
        String number = "1231234";
        int k = 3;

        Solution solution = new Solution();
        solution.solution(number, k);
    }

    private static class Solution {

        int answer = 0;
        String[] arr;

        public String solution(String number, int k) {


            int start = 0;
            String[] split = number.split("");
            int depth = 0;
            arr = new String[split.length - k];
            dfs(start, split, depth, split.length - k);

            return String.valueOf(answer);
        }

        private void dfs(int start, String[] split, int depth, int k) {
            if (depth == k) {
                StringBuilder sb = new StringBuilder();
                for (String s : arr) {
                    sb.append(s);
                }
                answer = Math.max(answer, Integer.parseInt(sb.toString()));
                return;
            }

            for (int i = start; i < split.length; i++) {

                arr[depth] = split[i];
                dfs(i + 1, split, depth + 1, k);
            }
        }
    }
}