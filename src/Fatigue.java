public class Fatigue {
    public static void main(String[] args) {
        int k = 80;

        int[][] d = {{80, 20}, {50, 40}, {30, 10}};

        int solution = solution(k, d);
        System.out.println("solution = " + solution);

    }

    public static int answer = 0;
    public static boolean[] visit;

    public static int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];

        dfs(0, k, dungeons);

        return answer;
    }

    public static void dfs(int depth, int k, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visit[i] && dungeons[i][0] <= k) {
                visit[i] = true;
                dfs(depth + 1, k - dungeons[i][1], dungeons);
                visit[i] = false;
            }
        }

        answer = Math.max(answer, depth);
    }
}
