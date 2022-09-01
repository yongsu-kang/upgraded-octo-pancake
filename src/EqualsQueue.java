import java.util.LinkedList;
import java.util.Queue;

public class EqualsQueue {
    public static void main(String[] args) {
        int[] q1 = {3, 2, 7, 2};
        int[] q2 = {4, 6, 5, 1};


        int solution = solution(q1, q2);
        System.out.println("solution = " + solution);
    }

    public static int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        long sum1 = 0, sum2 = 0;

        for (int i : queue1) {
            q1.offer(i);
            sum1 += i;
        }

        for (int i : queue2) {
            q2.offer(i);
            sum2 += i;
        }

        if ((sum1 + sum2) % 2 == 1) {
            return -1;
        }

        int answer = 0;

        while (sum1 != sum2) {
            answer++;
            if (sum1 > sum2) {
                int value = q1.poll();
                sum1 -= value;
                sum2 += value;
                q2.offer(value);
            } else {
                int value = q2.poll();
                sum2 -= value;
                sum1 += value;
                q1.offer(value);
            }

            if (answer > (queue1.length + queue2.length) * 2) {
                return -1;
            }
        }
        return answer;
    }



}
