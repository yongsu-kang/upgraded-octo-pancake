import java.util.Scanner;

public class Chess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        String[][] strings = new String[n][m];
        for (int i = 0; i < n; i++) {
            String[] split = scanner.next().split("");
            for (int j = 0; j < m; j++) {
                strings[i][j] = split[j];
            }
        }

        int result1 = solve("B",strings);
        int result2 = solve("W", strings);

        int answer = result1;
        if (result2 < result1)
            answer = result2;

        System.out.println(answer);
    }

    private static int solve(String print, String[][] strings) {
        int result = 0;
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length; j++) {
                if ((i + j) % 2 == 0 && !strings[i][j].equals(print))
                    result++;
                else if ((i + j) % 2 != 0 && strings[i][j].equals(print))
                    result++;
                else continue;
            }
        }
        return result;
    }


}
