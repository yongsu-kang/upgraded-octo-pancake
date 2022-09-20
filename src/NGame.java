public class NGame {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solution(2, 4, 2, 1));
        System.out.println("-------------------------");
        System.out.println(solution.solution(16, 16, 2, 1));

    }

    private static class Solution {
        public String solution(int n, int t, int m, int p) {
            StringBuilder answer = new StringBuilder();
            StringBuilder sb = new StringBuilder("0");

            for (int i = 0; i < (t * m); i++) {
                sb.append(nDecimal(n, i));
            }

            for (int i = p - 1; answer.length() != t; i += m) {
                answer.append(sb.charAt(i));
            }

            return answer.toString();
        }

        private String nDecimal(int n, int num) {
            StringBuilder sb = new StringBuilder();

            while (num != 0) {
                int tmp = num % n;

                if (tmp >= 10) {
                    sb.append(overTen(tmp));
                } else {
                    sb.append(tmp);
                }
                num /= n;
            }

            return sb.reverse().toString();
        }

        private String overTen(int num) {
            return switch (num) {
                case 10 -> "A";
                case 11 -> "B";
                case 12 -> "C";
                case 13 -> "D";
                case 14 -> "E";
                case 15 -> "F";
                default -> null;
            };
        }
    }
}
