import java.util.*;

import 자료구조.우선순위큐.PriorityQueue;

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

        Map<String, Integer> genreTotalPlay = new HashMap<>();
        Map<String, PriorityQueue<Song>> genreSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            genreTotalPlay.put(genre, genreTotalPlay.getOrDefault(genre, 0) + play);
            genreSongs.computeIfAbsent(genre, key -> new PriorityQueue<>())
                .add(new Song(genre, play, i));
        }

    }


}