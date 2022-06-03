import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(new Fibonacci().fibo(n));
    }

    private int fibo(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;

        return fibo(n - 1) + fibo(n - 2);
    }
}
