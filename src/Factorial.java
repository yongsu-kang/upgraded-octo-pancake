import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(new Factorial().factorial(n));
    }

    private int factorial(int n) {
        if (n <= 1)
            return 1;

        return n * factorial(n - 1);
    }
}
