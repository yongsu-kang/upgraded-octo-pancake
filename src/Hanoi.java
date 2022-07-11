import java.util.Scanner;

public class Hanoi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        hanoi(n, 1, 2, 3, 0);
    }

    private static void hanoi(int n, int from, int mid, int to, int count) {
        if (n == 0) {
            return;
        }

        hanoi(n - 1, from, to, mid, count++);
        System.out.printf("%d : %d -> %d\n", n, from, to);

        hanoi(n - 1, mid, from, to, count++);

    }

}
