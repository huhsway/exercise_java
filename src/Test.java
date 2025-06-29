import java.util.*;
public class Test {

    public static class Song implements Comparable<Song> {

        private final String genre;
        private final int plays;
        private final int index;

        public Song(String genre, int plays, int index) {
            this.genre = genre;
            this.plays = plays;
            this.index = index;
        }

        public int getIndex() {
            return this.index;
        }

        @Override
        public int compareTo(Song other) {
            return this.plays == other.plays ? this.index - other.index : other.plays - this.plays;
        }

    }



    public int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> genreTotalPlays = new HashMap<>();
        Map<String, PriorityQueue<Song>> genreSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            genreTotalPlays.put(genre, genreTotalPlays.getOrDefault(genre, 0) + play);
            genreSongs.computeIfAbsent(genre, key -> new PriorityQueue<>())
                    .offer(new Song(genre, play, i));
        }
        // genreList.sort((a,b) -> genreTotalPlays.get(b) - genreTotalPlays.get(a));

        List<String> genreList = genreTotalPlays.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .map(Map.Entry::getKey)
                .toList();

        List<Integer> answerList = new ArrayList<>();

        for (String genre : genreList) {
            PriorityQueue<Song> songs = genreSongs.get(genre);
            int count = 0;

            while (!songs.isEmpty() && count < 2) {
                answerList.add(songs.poll().getIndex());
                count++;
            }
        }

        return answerList.stream().mapToInt(Integer::intValue).toArray();

    }


}