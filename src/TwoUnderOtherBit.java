public class TwoUnderOtherBit {
    public static void main(String[] args) {
        Solution solution = new Solution();


        long[] numbers = {2, 7, 9};

        for (long l : solution.solution(numbers)) {
            System.out.println("l = " + l);
        }

    }

    private static class Solution {
        public long[] solution(long[] numbers) {
            long[] answer = new long[numbers.length];
            int i = 0;
            for (long number : numbers) {

                if (number % 2 == 0) {
                    answer[i++] = number + 1;
                    continue;
                }
                String s = Long.toBinaryString(number);

                if (s.replaceAll("1", "").length() == 0) {
                    answer[i++] = (long) (number + Math.pow(2,(s.length() - 1)));
                } else {
                    int lastIndexOfZero = s.lastIndexOf("0");
                    answer[i++] = (long) (number + Math.pow(2, (s.length() - lastIndexOfZero - 2)));
                }
            }
            return answer;
        }
    }
}
