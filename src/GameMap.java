public class GameMap {

    static int answer = Integer.MAX_VALUE;
    static boolean[][] visited;

    public static void main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};

        int solution = solution(maps);
        System.out.println("solution = " + solution);

    }

    public static int solution(int[][] maps) {

        visited = new boolean[maps.length][maps[0].length];
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length; j++) {
                visited[i][j] = true;
                if (maps[i][j] == 1) {
                    visited[i][j] = false;
                }
            }
        }

        dfs(maps, 0, 0, 0);
        return answer;
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    private static void dfs(int[][] maps,int sx,int sy,int depth) {

        if (sx == maps.length && sy == maps[0].length) {
            answer = Math.min(answer, depth);
            return;
        }


        visited[sx][sy] = true;
        for (int i = 0; i < 4; i++) {
            int x = sx + dx[i];
            int y = sy + dy[i];

            if (x < 0 || y < 0 || x >= maps.length || y >= maps[0].length) {
                continue;
            }

            if (maps[x][y] == 1 && !visited[x][y]) {
                dfs(maps, x, y, depth + 1);
            }
        }
        visited[sx][sy] = false;
    }
}
