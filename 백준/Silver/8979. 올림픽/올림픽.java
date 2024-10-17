import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int K;

	static int[] countrys;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int targetScore = 0;
		countrys = new int[N + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int bronze = Integer.parseInt(st.nextToken());

			int score = gold * 100 + silver * 10 + bronze;
			if (num == K)
				targetScore = score;
			countrys[num] = score;
		}

		Arrays.sort(countrys);

		for (int i = N; i > 0; --i) {
			if (countrys[i] == targetScore) {
				System.out.println(N - i + 1);
				return;
			}
		}
	}
}