import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] dp = new int[k+1];
		int[][] bag = new int[n+1][2];
		for(int i=1; i<n+1; i++) {
			st = new StringTokenizer(br.readLine());
			bag[i][0] = Integer.parseInt(st.nextToken());
			bag[i][1] = Integer.parseInt(st.nextToken());
		}
		for(int i=1; i<=n;i++){
			for(int j=k; j>= bag[i][0]; j--){
				dp[j] = Math.max(dp[j], (dp[j-bag[i][0]] + bag[i][1]));
			}
		}
		System.out.println(dp[k]);
	}

}
