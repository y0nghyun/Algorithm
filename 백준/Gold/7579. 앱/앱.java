import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] memory = new int[N + 1][2];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			memory[i][0] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			memory[i][1] = Integer.parseInt(st.nextToken());
		}
		int csum = 0;
		for (int i = 1; i <= N; i++) {
			csum += memory[i][1];
		}

		int[] dp = new int[csum + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = csum; j >= memory[i][1]; j--) {
				dp[j] = Math.max(dp[j - memory[i][1]] + memory[i][0], dp[j]);
			}
		}

		int ans = csum;
		for (int i = 0; i <= csum; i++) {
			if (dp[i] >= M) {
				ans = i;
				break;
			}
		}

		System.out.println(ans);
	}

}