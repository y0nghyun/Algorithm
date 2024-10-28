import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int X;

	static int[] days;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		days = new int[N];
		for (int i = 0; i < N; i++) {
			days[i] = Integer.parseInt(st.nextToken());
		}
		dp = new int[N];
		dp[0] = days[0];
		for (int i = 1; i < N; i++) {
			dp[i] = dp[i - 1] + days[i];
		}
		int max = dp[X - 1];
		int cnt = 1;
		for (int i = X; i < N; i++) {
			if (dp[i] - dp[i - X] > max) {
				max = dp[i] - dp[i - X];
				cnt = 1;
			} else if (dp[i] - dp[i - X] == max) {
				cnt++;
			}
		}
		if (max == 0) {
			System.out.println("SAD");
			return;
		}
		System.out.println(max);
		System.out.println(cnt);

	}

}