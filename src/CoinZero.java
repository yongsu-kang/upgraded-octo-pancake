import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoinZero {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int answer = 0;
        int n = scanner.nextInt();
        int price = scanner.nextInt();

        List<Integer> coins = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            coins.add(scanner.nextInt());
        }

        for (int i = coins.size() - 1; i >= 0; i--) {
            int coin = coins.get(i);
            if (coin <= price) {
                price -= coin;
                answer++;
                i++;
            }
        }

        System.out.println(answer);
    }
}
