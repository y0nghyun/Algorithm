import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[][] root;
	static int[][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		root = new int[N][M];
		dp = new int[N][M][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				root[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dp[i][j][0] = Integer.MAX_VALUE;
				dp[i][j][1] = Integer.MAX_VALUE;
				dp[i][j][2] = Integer.MAX_VALUE;
			}
		}

		for (int j = 0; j < M; j++) {
			dp[0][j][0] = root[0][j];
			dp[0][j][1] = root[0][j];
			dp[0][j][2] = root[0][j];
		}

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (j == 0) {
					dp[i][j][1] = dp[i - 1][j][2] + root[i][j];
					dp[i][j][2] = Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]) + root[i][j];
				} else if (j == M - 1) {
					dp[i][j][0] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]) + root[i][j];
					dp[i][j][1] = dp[i - 1][j][0] + root[i][j];
				} else {
					dp[i][j][0] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]) + root[i][j];
					dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + root[i][j];
					dp[i][j][2] = Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]) + root[i][j];
				}
			}
		}

		int ans = Integer.MAX_VALUE;
		for (int j = 0; j < M; j++) {
			for (int k = 0; k < 3; k++) {
				ans = Math.min(dp[N - 1][j][k], ans);
			}
		}

		System.out.println(ans);
	}
}