public class N2ArrayCut {
    public static void main(String[] args) {

        int n = 3;
        long left = 2;
        long right = 5;

        int[] solution = solution(n, left, right);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }

    public static int[] solution(int n, long left, long right) {
        int size = (int) (right - left) + 1;
        int[] answer = new int[size];

        int index = 0;

        for (long i = left; i <= right; i++) {
            answer[index] = (int) Math.max((i / n), (i % n)) + 1;
            index++;
        }

        return answer;
    }
}
