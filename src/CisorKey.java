public class CisorKey {
    public static void main(String[] args) {

        Solution solution = new Solution();
        solution.solution("AB", 1);
        solution.solution("z", 1);
        solution.solution("a B z", 4);
    }

    private static class Solution {
        public String solution(String s, int n) {
            StringBuilder answer = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == ' ') {
                    answer.append(c);
                    continue;
                }


                if (c <= 'Z') {
                    c += n;
                    if (c > 'Z') {
                        c = (char)('A' + (c - 'Z') - 1);
                    }
                }
                if (c >= 'a') {
                    c += n;
                    if (c > 'z') {
                        c = (char)('a' + (c - 'z') - 1);
                    }
                }
                answer.append(c);
            }

            return answer.toString();
        }
    }
}


