import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> times = new ArrayList<>();
        int answer = 0;
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            times.add(sc.nextInt());
        }
        Collections.sort(times);

        int min = 0;
        for (Integer time : times) {
            min += time;
            answer += min;
        }

        System.out.println(answer);
    }
}
