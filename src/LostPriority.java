import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LostPriority {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String formula = scanner.next();

        List<Integer> nums = new ArrayList<>(Arrays.stream(formula.split("[+-]")).map(Integer::parseInt).collect(Collectors.toList()));
        List<String> operations = new ArrayList<>(Arrays.stream(formula.replaceAll("[0-9]", "").split("")).toList());

        add(nums, operations);

        int result = nums.get(0);

        for (int i = 1; i < nums.size(); i++) {
            result -= nums.get(i);
        }

        System.out.println(result);
    }

    private static void add(List<Integer> nums, List<String> operations) {
        for (int i = 0; i < operations.size(); i++) {
            String operation = operations.get(i);
            if (operation.equals("+")) {
                int sum = nums.get(i) + nums.get(i + 1);
                nums.remove(i);
                nums.remove(i);
                nums.add(i,sum);
                operations.remove(i);
                i--;
            }
        }
    }

}
