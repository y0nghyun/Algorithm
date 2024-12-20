import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int sum;
	static int[] coins;
	static boolean[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int T = 0; T < 3; T++) {
			N = Integer.parseInt(br.readLine());

			sum = 0;
            // 동전 최대 가능이 100000원
			coins = new int[100001];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int coin = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				coins[coin] = cnt;
				sum += coin * cnt;
			}

			if (sum % 2 != 0) {
				System.out.println(0);
				continue;
			}

            // 한 명 꺼만 구하면 되니까
			sum /= 2;
			dp = new boolean[sum + 1];
			dp[0] = true;

            // 냅색
			for (int i = 1; i <= sum; i++) {
				if (coins[i] > 0) {
					int coin = i;
					int cnt = coins[i];
					for (int j = sum; j >= coin; j--) {
						for (int k = 1; k <= cnt && j >= k * coin; k++) {
							if (dp[j - k * coin]) {
								dp[j] = true;
							}
						}
					}
				}
			}

			if (dp[sum]) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}
}