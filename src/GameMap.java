import java.util.LinkedList;
import java.util.Queue;

public class GameMap {

    public static void main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};

        Solution solution = new Solution();
        int answer = solution.solution(maps);
    }

    private static class Solution {

        boolean[][] visited;
        int[][] mat;
        public int solution(int[][] maps) {
            int answer = 0;

            visited = new boolean[maps.length][maps[0].length];
            mat = maps.clone();

            bfs(0, 0);

            answer = mat[maps.length - 1][maps[0].length - 1];

            return answer <= 1 ? -1 : answer;
        }

        private void bfs(int x, int y) {
            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, 1, 0, -1};


            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{x, y});
            visited[x][y] = true;

            while (!q.isEmpty()) {
                int[] now = q.poll();
                int nowX = now[0];
                int nowY = now[1];

                for (int i = 0; i < 4; i++) {
                    int nextX = nowX + dx[i];
                    int nextY = nowY + dy[i];

                    if (nextX < 0 || nextY < 0 || nextX >= mat.length || nextY >= mat[0].length) {
                        continue;
                    }
                    if (visited[nextX][nextY] || mat[nextX][nextY] == 0) {
                        continue;
                    }

                    q.offer(new int[]{nextX, nextY});
                    mat[nextX][nextY] = mat[nowX][nowY] + 1;
                    visited[nextX][nextY] = true;
                }
            }

        }
    }
}
