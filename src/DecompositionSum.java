import java.util.Scanner;

public class DecompositionSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int answer = new DecompositionSum().solve(n);
        System.out.println(answer);
    }

    private int solve(int n) {
        int answer = 0;
        for (int i = n; i > 0; i--) {
            int result = i + sumOfLengthValue(i);
            if (result == n)
                answer = i;
        }
        return answer;
    }

    private int sumOfLengthValue(int num) {
        String number = String.valueOf(num);
        int sum = 0;
        for (String n : number.split("")) {
            sum += Integer.parseInt(n);
        }
        return sum;
    }
}
