import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Maze {

    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        arr = new int[n][m];
        visited = new boolean[n][m];

        String s;

        for (int i = 0; i < n; i++) {
            s = scanner.next();

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(s.charAt(j)+"");
            }
        }

        bfs(0, 0);

        System.out.println(arr[n - 1][m - 1]);
    }

    private static void bfs(int x, int y) {

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= arr.length || nextY >= arr[0].length) {
                    continue;
                }
                if (visited[nextX][nextY] || arr[nextX][nextY] == 0) {
                    continue;
                }

                queue.add(new int[]{nextX, nextY});
                arr[nextX][nextY] = arr[nowX][nowY] + 1;
                visited[nextX][nextY] = true;
            }
        }
    }
}
