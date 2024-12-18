import java.util.Arrays;

public class MoneyWallet {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{50,50}, new int[]{100,241}));
    }

    private static int solution(int[] wallet, int[] bill) {
        int answer = 0;

        while (true) {
            Arrays.sort(wallet);
            Arrays.sort(bill);

            if (wallet[1] < bill[1]){
                bill[1] /= 2;
                answer++;
            } else if (wallet[0] < bill[0]) {
                bill[1] /= 2;
                answer++;
            } else break;
        }

        return answer;
    }
}
