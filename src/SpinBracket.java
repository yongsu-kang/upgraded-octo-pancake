public class SpinBracket {
    public static void main(String[] args) {
        String s = "[](){}";

        int solution = solution(s);

        System.out.println("solution = " + solution);

    }

    public static int solution(String s) {
        int answer = 0;

        if (s.length() % 2 == 1) {
            return 0;
        }

        StringBuilder sb = new StringBuilder(s);

        int big = 0;
        int mid = 0;
        int small = 0;

        for (int i = 0; i < s.length(); i++) {
            String[] strings = sb.toString().split("");

            for (String string : strings) {
                if (big < 0 || mid < 0 || small < 0) {
                    break;
                }
                if (string.equals("{")) big++;
                else if (string.equals("}")) big--;
                else if (string.equals("[")) mid++;
                else if (string.equals("]")) mid--;
                else if (string.equals("(")) small++;
                else if (string.equals(")")) small--;
            }

            if (big == 0 && mid == 0 && small == 0) {
                answer++;
            }

            big = 0;
            mid = 0;
            small = 0;
            char c = sb.toString().charAt(0);
            sb.deleteCharAt(0);
            sb.append(c);
        }

        return answer;
    }
}
