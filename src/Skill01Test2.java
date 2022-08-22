public class Skill01Test2 {
    public static void main(String[] args) {
        int[] absolutes = {4, 7, 12};
        boolean[] signs = {true, false, true};

        int solution = solution(absolutes, signs);
        System.out.println("solution = " + solution);

    }

    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        int length = absolutes.length;
        for(int i = 0; i < length; i++) {
            int num = absolutes[i];

            if(signs[i]) {
                answer += num;
            }
            else {
                answer -= num;
            }
        }

        return answer;
    }
}
