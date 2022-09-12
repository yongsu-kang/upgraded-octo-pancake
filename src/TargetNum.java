public class TargetNum {

    static int count = 0;

    public static void main(String[] args) {
        int[] numbers = {4, 1, 2, 1};
        int target = 4;
        int solution = solution(numbers, target);
        System.out.println("solution = " + solution);

    }

    public static int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return count;
    }

    private static void dfs(int[] numbers, int target, int sum, int depth) {

        int length = numbers.length;
        if (depth == length) {
            if (sum == target) {
                count++;
            }
            return;
        }

        sum += numbers[depth];
        dfs(numbers, target, sum, depth + 1);

        sum -= (numbers[depth] * 2);
        dfs(numbers, target, sum, depth + 1);
    }
}
