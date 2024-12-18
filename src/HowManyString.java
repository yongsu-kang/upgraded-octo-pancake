public class HowManyString {
    public static void main(String[] args) {
        System.out.println(solution("banana","ana"));
        System.out.println("--------------");
        System.out.println(solution("aaaa","aa"));
    }

    private static int solution(String myString, String pat) {
        int answer = 0;
        String s;
        for (int i = 0; i <= myString.length() - pat.length(); i++){
            s = myString.substring(i,i+pat.length());
            if (s.equals(pat)){
                answer++;
            }
        }

        return answer;
    }
}
