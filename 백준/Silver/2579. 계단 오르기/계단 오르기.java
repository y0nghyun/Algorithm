import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int[] stairs;
	static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		stairs = new int[N];
		dp = new int[N];

		for (int i = 0; i < N; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}

		dp[0] = stairs[0];
		if (N == 1) {
			System.out.println(dp[0]);
			return;
		}
		dp[1] = stairs[1] + dp[0];
		if (N == 2) {
			System.out.println(dp[1]);
			return;
		}
		dp[2] = Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]);
		for (int i = 3; i < N; i++) {
			dp[i] = Math.max(dp[i - 2] + stairs[i], dp[i - 3] + stairs[i - 1] + stairs[i]);
		}
		System.out.println(dp[N - 1]);
	}

}