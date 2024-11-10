import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static class Title {
		String name;
		int score;

		public Title(String name, int score) {
			this.name = name;
			this.score = score;
		}
	}

	static ArrayList<Title> titles = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int prev = -1;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String rank = st.nextToken();
			int score = Integer.parseInt(st.nextToken());

			if (prev == score)
				continue;
			titles.add(new Title(rank, score));
			prev = score;
		}

		for (int i = 0; i < m; i++) {
			int target = Integer.parseInt(br.readLine());
			int min = 0;
			int max = titles.size() - 1;

			while (min < max) {
				int mid = (min + max) / 2;
				if (target <= titles.get(mid).score) {
					max = mid;
				} else {
					min = mid + 1;
				}
			}

			sb.append(titles.get(min).name).append("\n");
		}

		System.out.print(sb.toString());
	}
}