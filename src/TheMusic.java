import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class TheMusic {

    public static void main(String[] args) {
        String m = "ABC";
        String[] musicifos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};


        Solution solution = new Solution();

        String answer = solution.solution(m, musicifos);

        System.out.println("answer = " + answer);
    }

    private static class Solution {
        public String solution(String m, String[] musicinfos) {
            String melody = changeMelody(m);
            long maxTime = -1L;
            String answer = "";

            for (int i = 0; i < musicinfos.length; i++) {
                String[] music = musicinfos[i].split(",");
                String[] startTime = music[0].split(":");
                String[] endTime = music[1].split(":");
                String title = music[2];
                String[] codes = changeMelody(music[3]).split("");

                Long minute = getBetweenMinute(startTime, endTime);
                String musicInfo = musicInfo(codes, minute);

                if (musicInfo.contains(melody)) {
                    if (maxTime < minute) {
                        maxTime = minute;
                        answer = title;
                    }
                }
            }
            return maxTime == -1L ? "(None)" : answer;
        }

        private String musicInfo(String[] codes, Long minute) {
            Long count = 0L;
            int index = 0;
            StringBuilder sb = new StringBuilder();

            while (count < minute) {

                if (index >= codes.length) {
                    index = 0;
                }
                String code = codes[index];
                sb.append(code);
                index++;
                count++;
            }

            return sb.toString();
        }

        private Long getBetweenMinute(String[] startTime, String[] endTime) {
            int st = Integer.parseInt(startTime[0]);
            int sm = Integer.parseInt(startTime[1]);

            LocalTime start = LocalTime.of(st, sm);

            int et = Integer.parseInt(endTime[0]);
            int em = Integer.parseInt(endTime[1]);
            LocalTime end = LocalTime.of(et, em);

            return ChronoUnit.MINUTES.between(start, end);
        }

        private String changeMelody(String melody) {
            melody = melody.replaceAll("A#", "H");
            melody = melody.replaceAll("C#", "I");
            melody = melody.replaceAll("D#", "J");
            melody = melody.replaceAll("F#", "K");
            String newMelody = melody.replaceAll("G#", "L");

            return newMelody;
        }
    }
}
