package 베스트앨범;

import java.util.*;
/**
 * 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
 * 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
 * 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
 *
 * Music 클래스 만들어서 속한 노래 가장 많이 재생된 장르로 찾고
 * 장르 내에서 많이 재생된 노래 순으로, 인덱스 낮은 순으로 정렬하고 최대 2개 저장
 */

public class Solution {
    public static class Song implements Comparable<Song> {
        String genre;
        int plays;
        int index;

        public Song(String genre, int plays, int index) {
            this.genre = genre;
            this.plays = plays;
            this.index = index;
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
            genreSongs.computeIfAbsent(genre, k -> new PriorityQueue<>())
                    .add(new Song(genre, play, i));
        }

        List<String> genreList = new ArrayList<>(genreTotalPlays.keySet());
        genreList.sort((a, b) -> genreTotalPlays.get(b) - genreTotalPlays.get(a));

        List<Integer> answerList = new ArrayList<>();

        for (String genre : genreList) {
            PriorityQueue<Song> songs = genreSongs.get(genre);
            int count = 0;

            while (!songs.isEmpty() && count < 2) {
                answerList.add(songs.poll().index);
                count++;
            }
        }

        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};


        Solution solution = new Solution();
        int[] result = solution.solution(genres, plays);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }

}



//class Solution {
//
//    public static class Music implements Comparable<Music> {
//
//        private int cnt;
//        private int index;
//
//        public Music(int cnt, int index) {
//            this.cnt = cnt;
//            this.index = index;
//        }
//
//        public int getIndex() {
//            return this.index;
//        }
//
//        @Override
//        public int compareTo(Music music) {
//            if (this.cnt < music.cnt) {
//                return 1;
//            }
//            else if (this.cnt > music.cnt) {
//                return -1;
//            }
//            else {
//                return Integer.compare(this.index, music.index);
//            }
//        }
//    }
//
//    public int[] solution(String[] genres, int[] plays) {
//        ArrayList<Integer> answer = new ArrayList<>();
//
//        HashMap<String, Integer> mostGenres = new HashMap<>();
//        HashMap<String, ArrayList<Music>> playCnt = new HashMap<>();
//
//        for (int i = 0; i < genres.length; i++) {
//            if(!mostGenres.containsKey(genres[i])) {
//                mostGenres.put(genres[i], plays[i]);
//                playCnt.put(genres[i], new ArrayList<Music>());
//            }
//            else {
//                mostGenres.put(genres[i], mostGenres.get(genres[i]) + plays[i]);
//            }
//            ArrayList<Music> tempPlayCnt = playCnt.get(genres[i]);
//            tempPlayCnt.add(new Music(plays[i], i ));
//            playCnt.put(genres[i], tempPlayCnt);
//        }
//
//        List<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(mostGenres.entrySet());
//        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
//            @Override
//            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//                return Integer.compare(o2.getValue(), o1.getValue());
//            }
//        });
//
//        for (Map.Entry<String, Integer> entry : entries) {
//            String tempGenres = entry.getKey();
//            ArrayList<Music> tempMusic = playCnt.get(tempGenres);
//            Collections.sort(tempMusic);
//            if (tempMusic.size() < 2) {
//                for (int i = 0; i < tempMusic.size(); i++) {
//                    answer.add(tempMusic.get(i).getIndex());
//                }
//            }
//            else {
//                for (int i = 0; i < 2; i++) {
//                    answer.add(tempMusic.get(i).getIndex());
//                }
//            }
//        }
//
//        int[] result = new int[answer.size()];
//
//        for (int i = 0; i < answer.size(); i++){
//            result[i] = answer.get(i);
//        }
//
//        return result;
//    }
//
//    public static void main(String[] args) {
//        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
//        int[] plays = {500, 600, 150, 800, 2500};
//        Solution sol = new Solution();
//        System.out.println(Arrays.toString(sol.solution(genres, plays)));
//    }
//
//}

//import java.util.*;
//
//class Solution {
//
//    public static class Music implements Comparable<Music> {
//        int uniqNum;
//        int plays;
//
//        public Music (int uniqNum, int plays) {
//            this.uniqNum = uniqNum;
//            this.plays = plays;
//        }
//
//        @Override
//        public int compareTo(Music music) {
//            if (this.plays < music.plays) {
//                return 1;
//            }
//            else if (this.plays > music.plays) {
//                return -1;
//            }
//            else {
//                if (this.uniqNum < music.uniqNum) { return -1; }
//                else if (this.uniqNum == music.uniqNum) {
//                    return 0;
//                }
//                else { return 1; }
//            }
//        }
//
//    }
//
//    public int[] solution(String[] genres, int[] plays) {
//        int[] answer = {};
//        HashMap<String, Integer> genresPlayCnt = new HashMap<String, Integer> ();
//        HashMap<String, ArrayList<Music>> musicList = new HashMap<String, ArrayList<Music>>();
//
//        for (int i = 0; i < genres.length; i++) {
//            if(genresPlayCnt.containsKey(genres[i])) {
//                genresPlayCnt.put(genres[i], (genresPlayCnt.get(genres[i]) + plays[i]));
//            } else {
//                genresPlayCnt.put(genres[i], plays[i]);
//                musicList.put(genres[i], new ArrayList<Music>());
//            }
//            ArrayList<Music> tempMusicList = musicList.get(genres[i]);
//            tempMusicList.add(new Music(i, plays[i]));
//            musicList.put(genres[i], tempMusicList);
//        }
//
//        List<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(genresPlayCnt.entrySet());
//        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
//            @Override
//            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
//                if(obj1.getValue() < obj2.getValue()) return 1;
//                else if (obj1.getValue() == obj2.getValue()) return 0;
//                else return -1;
//            }
//        });
//
//        ArrayList<Integer> tempAnswer = new ArrayList<Integer>();
//        String musicGenre = "";
//        for (Map.Entry<String, Integer> entry : entries) {
//            musicGenre = entry.getKey();
//            ArrayList<Music> sortMusicList = musicList.get(musicGenre);
//            Collections.sort(sortMusicList);
//            if (sortMusicList.size() < 2) {
//                for (int i = 0; i < sortMusicList.size(); i++) {
//                    tempAnswer.add(sortMusicList.get(i).uniqNum);
//                }
//            } else {
//                for (int i = 0; i < 2; i++) {
//                    tempAnswer.add(sortMusicList.get(i).uniqNum);
//                }
//            }
//        }
//
//        answer = new int[tempAnswer.size()];
//        for(int i = 0; i < tempAnswer.size(); i++) {
//            answer[i] = tempAnswer.get(i);
//        }
//
//        return answer;
//
//
//    }
//
//    public static void main(String[] args) {
//        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
//        int[] plays = {500, 600, 150, 800, 2500};
//        Solution sol = new Solution();
//        System.out.println(Arrays.toString(sol.solution(genres, plays)));
//    }
//
//}


