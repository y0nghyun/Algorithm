import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int num = Integer.parseInt(s);
		dp = new int[num+1];

		dp[0] = dp[1] = 0;
		if(num > 1)
			dp[2] = 1;
		if(num > 2)
			dp[3] = 1;
		if(num > 3) {
			for(int i=4; i<num+1; i++)
				dp[i] = recur(i);
		}
		System.out.println(dp[num]);
	}
	
	
	
	static int recur(int n) {
		int ans;
		int tmp;
		ans = dp[n-1]+1;
		if(n % 3 == 0) {
			tmp = dp[n/3]+1;
			ans = (tmp<ans)?tmp:ans;
		}
		if(n % 2 ==0) {
			tmp = dp[n/2]+1;
			ans = (tmp<ans)?tmp:ans;
		}
		return ans;
	}
}
