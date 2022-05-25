import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ConferenceRoomAssignment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] times = new int[n][2];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            times[i][0] = scanner.nextInt();
            times[i][1] = scanner.nextInt();
        }

        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1])
                    return o1[0] - o2[0];
                else
                    return o1[1] - o2[1];
            }
        });

        int finishedTime = 0;
        for (int i = 0; i < n; i++) {
            int start = times[i][0];
            int finish = times[i][1];

            if (start >= finishedTime) {
                finishedTime = finish;
                answer++;
            }
        }

        System.out.println(answer);
    }
}
