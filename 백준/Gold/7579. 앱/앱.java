import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
		int sum = 0;
		int csum = 0;
		for (int i = 1; i <= N; i++) {
			sum += memory[i][0];
			csum += memory[i][1];
		}
		int[] dp = new int[sum + 1];

		Arrays.fill(dp, csum);
		for (int i = 1; i <= N; i++) {
			for (int j = sum; j >= memory[i][0]; j--) {
				dp[j] = Math.min(dp[j - memory[i][0]] + memory[i][1], dp[j]);
			}
			dp[memory[i][0]] = Math.min(dp[memory[i][0]], memory[i][1]);
		}
		int min = csum;
		for (int i = M; i <= sum; i++) {
			csum = Math.min(csum, dp[i]);
		}
		System.out.println(csum);
	}

}