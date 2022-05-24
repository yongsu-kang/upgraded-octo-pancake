import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GameMapMinLength {

    public static void main(String[] args) {
        int[][] map1 = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        int[][] map2 = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}};

        int solution1 = new GameMapMinLength().solution(map1);
        int solution2 = new GameMapMinLength().solution(map2);

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }

    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};
    boolean[][] visited;
    int n, m;

    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;

        visited = new boolean[n][m];
        return bfs(0, 0, maps);
    }

    private int bfs(int x, int y, int[][] maps) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 1));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.x == n -1 && node.y == m-1) return node.cost;

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (maps[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offer(new Node(nx, ny, node.cost + 1));
                    }
                }
            }
        }
        return -1;
    }

    public class Node{
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
