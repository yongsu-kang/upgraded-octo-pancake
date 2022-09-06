import java.util.ArrayList;
import java.util.List;

public class Hanoi {

    public static void main(String[] args) {
        int n = 2;

        solution(3);
    }

    public static int[][] solution(int n) {


        List<List<Integer>> list = new ArrayList<>();

        hanoi(list,n, 1, 2, 3);

        for (List<Integer> integers : list) {
            System.out.println("integers = " + integers);
        }

        int[][] answer = new int[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            answer[i][0] = list.get(i).get(0);
            answer[i][1] = list.get(i).get(1);
        }
        return answer;
    }

    private static void hanoi(List<List<Integer>> list, int n, int start, int mid, int to) {
        if (n == 1) {
            list.add(List.of(start, to));
            return;
        }

        hanoi(list, n - 1, start, to, mid);

        list.add(List.of(start, to));

        hanoi(list,n - 1, mid, start, to);
    }
}
