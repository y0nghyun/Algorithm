import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int west;
	static int east;

	static int[][] dp;
	static int ans;

	private static void build() {
		for (int i = 0; i < east; i++)
			dp[0][i] = i + 1;
		for (int i = 1; i < west; i++) {
			for (int j = i; j < east; j++) {
				for (int k = j - 1; k >= 0; k--) {
					dp[i][j] += dp[i - 1][k];
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tNum = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= tNum; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			west = Integer.parseInt(st.nextToken());
			east = Integer.parseInt(st.nextToken());
			dp = new int[west][east];
			build();
			System.out.println(dp[west - 1][east - 1]);
		}

	}

}