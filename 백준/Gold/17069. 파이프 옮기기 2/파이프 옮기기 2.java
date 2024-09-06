import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map;
	static long[][][] dp;

	private static void find() {
		dp[0][0][0] = 1; // 3차원 0 : 가로 1: 세로 2: 대각선
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 1) {
					if (i - 1 >= 0 && j - 1 >= 0 && map[i - 1][j] != 1 && map[i][j - 1] != 1) {
						dp[i][j][0] += dp[i - 1][j - 1][2];
						dp[i][j][1] += dp[i - 1][j - 1][2];
						dp[i][j][2] += dp[i - 1][j - 1][2];

					}
					if (i - 1 >= 0) {
						dp[i][j][1] += dp[i - 1][j][1];
						dp[i][j][2] += dp[i - 1][j][1];
					}
					if (j - 1 >= 0) {
						dp[i][j][0] += dp[i][j - 1][0];
						dp[i][j][2] += dp[i][j - 1][0];
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		dp = new long[N][N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		find();

		long ans = 0;
		if (map[N - 2][N - 1] != 1 && map[N - 1][N - 2] != 1) {
			ans += dp[N - 2][N - 2][2];
		}

		ans += dp[N - 2][N - 1][1];
		ans += dp[N - 1][N - 2][0];
		if (map[N - 1][N - 1] == 1)
			ans = 0;
		System.out.println(ans);

	}

}