import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static class Word implements Comparable<Word> {
		String word;
		int cnt;

		public Word(String word, int cnt) {
			this.word = word;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Word o) {
			if (this.cnt != o.cnt) {
				return Integer.compare(o.cnt, this.cnt);
			}

			if (this.word.length() != o.word.length()) {
				return Integer.compare(o.word.length(), this.word.length());
			}

			return this.word.compareTo(o.word);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<String, Integer> dict = new HashMap<>();

		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			if (temp.length() < M)
				continue;
			dict.put(temp, dict.getOrDefault(temp, 0) + 1);
		}

		List<Word> wordList = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : dict.entrySet()) {
			wordList.add(new Word(entry.getKey(), entry.getValue()));
		}

		Collections.sort(wordList);

		StringBuilder sb = new StringBuilder();
		for (Word word : wordList) {
			sb.append(word.word).append("\n");
		}
		System.out.print(sb);
	}
}