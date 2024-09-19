import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String f = br.readLine();
		String s = br.readLine();
		int[][] dp = new int[f.length()][s.length()];
		
		for(int i=0; i<f.length(); i++)
			for(int j=0; j<s.length();j++) {
				if( f.charAt(i) == s.charAt(j)) {
					if(i == 0)
						dp[i][j] = 1;
					else {
						if(j != 0)
							dp[i][j] = dp[i-1][j-1] + 1;
						else
							dp[i][j] = Math.max(dp[i-1][j], 1);
					}
				}
				else {
					if(i == 0) {
						if(j == 0)
							dp[i][j] = 0;
						else
							dp[i][j] = dp[i][j-1];
						}
					else
						if(j != 0)
							dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
						else
							dp[i][j] = dp[i-1][j];
				}
			}
		
		System.out.println(dp[f.length()-1][s.length()-1]);
	
	}

}
