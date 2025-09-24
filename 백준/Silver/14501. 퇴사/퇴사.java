import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] end = new int[n + 1];
		int[] pay = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			end[i] = i + t;
			pay[i] = p;
		}

		int[] dp = new int[n + 2];

		for (int i = 1; i <= n + 1; i++) {
			dp[i] = Math.max(dp[i], dp[i - 1]);

			if (i <= n && end[i] <= n + 1) {
				dp[end[i]] = Math.max(dp[end[i]], dp[i] + pay[i]);
			}
		}

		System.out.println(dp[n + 1]);
	}
}
