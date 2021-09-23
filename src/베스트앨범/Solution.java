package 베스트앨범;

import java.util.*;

class Solution {

    public static class Music implements Comparable<Music> {
        int uniqNum;
        int plays;

        public Music (int uniqNum, int plays) {
            this.uniqNum = uniqNum;
            this.plays = plays;
        }

        @Override
        public int compareTo(Music music) {
            if (this.plays < music.plays) {
                return 1;
            }
            else if (this.plays > music.plays) {
                return -1;
            }
            else {
                if (this.uniqNum < music.uniqNum) { return -1; }
                else if (this.uniqNum == music.uniqNum) {
                    return 0;
                }
                else { return 1; }
            }
        }

    }

    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<String, Integer> genresPlayCnt = new HashMap<String, Integer> ();
        HashMap<String, ArrayList<Music>> musicList = new HashMap<String, ArrayList<Music>>();

        for (int i = 0; i < genres.length; i++) {
            if(genresPlayCnt.containsKey(genres[i])) {
                genresPlayCnt.put(genres[i], (genresPlayCnt.get(genres[i]) + plays[i]));
            } else {
                genresPlayCnt.put(genres[i], plays[i]);
                musicList.put(genres[i], new ArrayList<Music>());
            }
            ArrayList<Music> tempMusicList = musicList.get(genres[i]);
            tempMusicList.add(new Music(i, plays[i]));
            musicList.put(genres[i], tempMusicList);
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(genresPlayCnt.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
                if(obj1.getValue() < obj2.getValue()) return 1;
                else if (obj1.getValue() == obj2.getValue()) return 0;
                else return -1;
            }
        });

        ArrayList<Integer> tempAnswer = new ArrayList<Integer>();
        String musicGenre = "";
        for (Map.Entry<String, Integer> entry : entries) {
            musicGenre = entry.getKey();
            ArrayList<Music> sortMusicList = musicList.get(musicGenre);
            Collections.sort(sortMusicList);
            if (sortMusicList.size() < 2) {
                for (int i = 0; i < sortMusicList.size(); i++) {
                    tempAnswer.add(sortMusicList.get(i).uniqNum);
                }
            } else {
                for (int i = 0; i < 2; i++) {
                    tempAnswer.add(sortMusicList.get(i).uniqNum);
                }
            }
        }

        answer = new int[tempAnswer.size()];
        for(int i = 0; i < tempAnswer.size(); i++) {
            answer[i] = tempAnswer.get(i);
        }

        return answer;


    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(genres, plays)));
    }

}


