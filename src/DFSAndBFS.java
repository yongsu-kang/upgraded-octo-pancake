import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFSAndBFS {

    static int[][] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int v = scanner.nextInt();

        arr = new int[n+1][n+1];
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        visited = new boolean[n + 1];
        dfs(v);
        sb.append("\n");

        visited = new boolean[n + 1];
        bfs(v);

        System.out.println(sb);
    }



    private static void dfs(int v) {
        visited[v] = true;
        sb.append(v).append(" ");

        if (v == arr.length) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[v][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;
        sb.append(v).append(" ");

        while (!q.isEmpty()) {
            int index = q.poll();

            for (int i = 1; i < arr.length; i++) {
                if (arr[index][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    sb.append(i).append(" ");
                }
            }
        }
    }
}
