public class Skill01Test1 {
    public static void main(String[] args) {
        long[] answer;
        int n = 5;
        int x = 2;

        long[] solution = solution(x, n);

        for (long l : solution) {
            System.out.println("l = " + l);
        }
    }

    public static long[] solution(int x, int n) {
        long[] answer = new long[n];

        int num = 0;

        for (int i = 0; i < n; i++) {
            num += x;
            answer[i] = num;
        }

        return answer;
    }
}
