import java.util.*;
import java.util.stream.Collectors;

public class BestAlbum {

    public static void main(String[] args) {
        String[] genres = {"c","a","b","a","c"};
        int[] plays = {500, 600, 1400, 800, 900};

        int[] solution = solution(genres, plays);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }

    public static int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> allPlays = new HashMap<>();
        countGenresPlays(allPlays, genres, plays);

        List<String> sortedGenre = sortGenres(allPlays,genres);

        Map<String, List<Integer>> genresPlays = new HashMap<>();
        addGenresPlays(genresPlays, genres, plays);

        List<Integer> answers = new ArrayList<>();

        for (String genre : sortedGenre) {
            List<Integer> playCounts = genresPlays.get(genre);
            int size = playCounts.size();

            addAnswers(genres, plays, answers, genre, playCounts.get(0));
            if (size > 1) {
                addAnswers(genres, plays, answers, genre, playCounts.get(1));
            }
        }

        int[] answer = new int[answers.size()];

        for (int i = 0; i < answers.size(); i++) {
            answer[i] = answers.get(i);
        }

        return answer;
    }

    private static void addAnswers(String[] genres, int[] plays, List<Integer> answers, String genre, Integer count) {
        for (int i = 0; i < genres.length; i++) {
            if (genres[i].equals(genre) && plays[i] == count) {
                answers.add(i);
                plays[i] = -1;
            }
        }
    }

    private static List<String> sortGenres(Map<String, Integer> allPlays, String[] genres) {
        List<String> sortedGenre = new ArrayList<>();
        List<String> genreNum = new ArrayList<>();

        for (String genre : genres) {
            if (!genreNum.contains(genre)) {
                genreNum.add(genre);
            }
        }

        List<Integer> values = allPlays.values().stream().sorted().collect(Collectors.toList());
        Collections.reverse(values);

        for (Integer value : values) {
            for (String genre : genreNum) {
                Integer playCount = allPlays.get(genre);

                if (Objects.equals(value, playCount)) {
                    sortedGenre.add(genre);
                    genreNum.remove(genre);
                    break;
                }
            }
        }

        return sortedGenre;
    }

    private static void addGenresPlays(Map<String, List<Integer>> genresPlays, String[] genres, int[] plays) {
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            if (genresPlays.containsKey(genre)) {
                List<Integer> playCount = genresPlays.get(genre);
                playCount.add(play);
                genresPlays.replace(genre, playCount);
            } else {
                List<Integer> playCount = new ArrayList<>();
                playCount.add(play);
                genresPlays.put(genre, playCount);
            }
        }

        genresPlays.forEach((genre, playList) -> {
            Collections.sort(playList);
            Collections.reverse(playList);
        });
    }

    private static void countGenresPlays(Map<String, Integer> allPlays, String[] genres, int[] plays) {
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            if (allPlays.containsKey(genre)) {
                Integer allPlayCount = allPlays.get(genre);
                allPlays.replace(genre, allPlayCount + play);
            } else {
                allPlays.put(genre, play);
            }
        }
    }
}
