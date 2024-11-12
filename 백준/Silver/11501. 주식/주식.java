import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int TC = 0; TC < T; TC++) {
			int N = Integer.parseInt(br.readLine());
			int[] days = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				days[i] = Integer.parseInt(st.nextToken());
			}

			int maxPrice = 0;
			long ans = 0;
			for (int i = N - 1; i >= 0; i--) {
				maxPrice = Math.max(maxPrice, days[i]);
				ans += maxPrice - days[i];
			}

			System.out.println(ans);
		}
	}
}