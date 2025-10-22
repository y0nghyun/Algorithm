import java.util.*;

class Solution {
    static class Song {
        int idx, plays;
        Song(int idx, int plays) {
            this.idx = idx;
            this.plays = plays;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreTotal = new HashMap<>();
        Map<String, List<Song>> genreSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String g = genres[i];
            int p = plays[i];

            genreTotal.put(g, genreTotal.getOrDefault(g, 0) + p);
            genreSongs.computeIfAbsent(g, k -> new ArrayList<>()).add(new Song(i, p));
        }

        List<String> orderedGenres = new ArrayList<>(genreTotal.keySet());
        orderedGenres.sort((a, b) -> genreTotal.get(b) - genreTotal.get(a));

        List<Integer> answerList = new ArrayList<>();

        for (String g : orderedGenres) {
            List<Song> list = genreSongs.get(g);

            list.sort((s1, s2) -> {
                if (s2.plays != s1.plays) return s2.plays - s1.plays;
                return s1.idx - s2.idx;
            });

            answerList.add(list.get(0).idx);
            if (list.size() > 1) answerList.add(list.get(1).idx);
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) answer[i] = answerList.get(i);
        return answer;
    }
}
