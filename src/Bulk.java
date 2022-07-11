import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bulk {
    public static void main(String[] args) {
        solve(createMembers()).forEach(answer -> System.out.print(answer + " "));
    }

    private static List<Integer> solve(List<Member> members) {
        List<Integer> answers = new ArrayList<>();
        for (int i = 0; i < members.size(); i++) {
            int index = 1;
            for (int j = 0; j < members.size(); j++) {
                Member member_i = members.get(i);
                Member member_j = members.get(j);

                if (member_i.getHeight() < member_j.getHeight() && member_i.getWeight() < member_j.getWeight())
                    index++;
                else
                    continue;
            }
            answers.add(index);
        }
        return answers;
    }

    private static List<Member> createMembers() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Member> members = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            members.add(new Member(scanner.nextInt(), scanner.nextInt()));
        }
        return members;
    }
}
class Member{
    private int weight;
    private int height;

    public Member(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }
}