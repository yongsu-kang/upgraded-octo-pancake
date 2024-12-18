import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Treasure {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int answer = 0;
        int s = sc.nextInt();

        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        int i;

        for(i=0 ;i<s;i++){
            a.add(i,sc.nextInt());
        }

        for (i=0;i<s;i++){
            b.add(i,sc.nextInt());
        }

        Collections.sort(a);
        b.sort(Collections.reverseOrder());

        for (i=0;i<a.size();i++) {
            answer += a.get(i)*b.get(i);
        }

        System.out.println(answer);
    }
}
