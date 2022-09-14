public class TriangleSnail {
    public static void main(String[] args) {
        int n = 4;

        int[] ints = solution(n);
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }
    }

    public static int[] solution(int n) {
        int[] answer = new int[(n*(n+1))/2];
        int[][] matrix = new int[n][n];

        int count = 1;
        int x = -1;
        int y = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                if (i % 3 == 0) {
                    x++;
                } else if (i % 3 == 1) {
                    y++;
                } else {
                    x--;
                    y--;
                }

                matrix[x][y] = count;
                count++;
            }
        }

        int index = 0;
        for (int[] arr : matrix) {
            for (int i : arr) {
                if (i == 0) {
                    break;
                }
                answer[index] = i;
                index++;
            }
        }
        return answer;
    }
}
