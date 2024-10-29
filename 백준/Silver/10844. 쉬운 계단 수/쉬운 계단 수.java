import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[][] dp = new long[n + 1][10];
		long num = 1000000000;
		for (int i = 1; i < 10; i++) {
			dp[1][i] = 1;
		}
		for (int i = 2; i < n + 1; i++) {
			dp[i][0] = dp[i - 1][1] % num;
			for (int j = 1; j < 9; j++) {
				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % num;
			}
			dp[i][9] = dp[i - 1][8] % num;
		}
		long ans = 0;
		if (n == 1)
			ans = 9;
		else {
			for (int i = 0; i < 10; i++) {
				ans += dp[n][i];
			}
		}
		System.out.println(ans % num);
	}

}