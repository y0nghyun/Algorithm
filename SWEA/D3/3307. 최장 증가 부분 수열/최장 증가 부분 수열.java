import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tNum = Integer.parseInt(br.readLine());

		for (int TC = 1; TC <= tNum; TC++) {

			int n = Integer.parseInt(br.readLine());
			int[] num = new int[n];
			int[] dp = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++)
				num[i] = Integer.parseInt(st.nextToken());

			dp[0] = 1;
			int max = 1;
			for (int i = 1; i < num.length; i++) {
				for (int j = i - 1; j >= 0; j--) {
					if (num[i] > num[j] && dp[j] + 1 > dp[i]) {
						dp[i] = dp[j] + 1;
						if (max < dp[i])
							max = dp[i];
					}
				}
				if (dp[i] == 0)
					dp[i] = 1;
			}
			System.out.println("#" + TC + " " + max);
		}
	}
}