public class Carpet {
    public static void main(String[] args) {
        int b1 = 10;
        int y1 = 2;

        solution(b1, y1);

        int b2 = 8;
        int y2 = 1;

        solution(b2, y2);

        int b3 = 24;
        int y3 = 24;

        solution(b3, y3);
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        double sqrt = Math.sqrt(sum);

        int value = (int) sqrt;
        while (true) {

            if (sum % value == 0) {
                int divisor = sum / value;

                if (brown == (divisor + value) * 2 - 4) {
                    answer[0] = value;
                    answer[1] = divisor;
                    if (divisor > value) {
                        answer[0] = divisor;
                        answer[1] = value;
                    }
                    break;
                }
            }
            value++;
        }

        return answer;
    }
}
