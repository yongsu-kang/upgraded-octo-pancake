import java.util.Scanner;

public class NM2 {
    static StringBuilder sb = new StringBuilder();
    static int[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        arr = new int[m];

        dfs(n, m, 0, 1);
        System.out.println(sb);
    }

    private static void dfs(int n, int m, int depth, int val) {

        if (depth == m) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }


        for (int i = val; i <= n; i++) {
            arr[depth] = i;
            dfs(n, m, depth + 1, i + 1);
        }
    }
}
