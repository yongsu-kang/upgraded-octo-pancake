import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int max = scanner.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        int answer = 0;
        for (int i = 0; i < list.size() - 2; i++) {
            for (int j = i + 1; j < list.size() - 1; j++) {
                for (int k = j + 1; k < list.size(); k++) {
                    int result = list.get(i) + list.get(j) + list.get(k);
                    if (result > answer && result <= max) {
                        answer = result;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
