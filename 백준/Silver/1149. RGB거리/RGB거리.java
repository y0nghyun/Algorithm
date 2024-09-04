import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] house = new int[n][3];
		int[][] dp = new int [n][3];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			house[i][0] = Integer.parseInt(st.nextToken());
			house[i][1] = Integer.parseInt(st.nextToken());
			house[i][2] = Integer.parseInt(st.nextToken());
		}
		dp[0][0] = house[0][0];
		dp[0][1] = house[0][1];
		dp[0][2] = house[0][2];
		
		for(int i=1; i<dp.length; i++) {
			dp[i][0] = house[i][0] + Math.min(dp[i-1][1],dp[i-1][2]);
			dp[i][1] = house[i][1] + Math.min(dp[i-1][0],dp[i-1][2]);
			dp[i][2] = house[i][2] + Math.min(dp[i-1][0],dp[i-1][1]);
		}
		int min = dp[n-1][0];
		for(int i=1; i<3; i++) {
			if(dp[n-1][i] < min)
				min = dp[n-1][i];
		}
		System.out.println(min);
	}
}