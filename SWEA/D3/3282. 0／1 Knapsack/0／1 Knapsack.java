import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= T; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[] items = new int[N + 1];
			int[] cost = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				items[i] = Integer.parseInt(st.nextToken());
				cost[i] = Integer.parseInt(st.nextToken());
			}

			int[] dp = new int[K + 1];

			for (int i = 1; i <= N; i++) {
				for (int j = K; j >= items[i]; j--) {
					dp[j] = Math.max(dp[j], dp[j - items[i]] + cost[i]);
				}
			}
			System.out.println("#" + TC + " " + dp[K]);
		}
	}

}