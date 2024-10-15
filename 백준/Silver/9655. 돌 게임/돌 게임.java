import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] dp = new String[N + 1];
		if (N == 1) {
			System.out.println("SK");
            return;
		} else if (N == 2) {
			System.out.println("CY");
            return;
		} else if (N == 3) {
			System.out.println("SK");
            return;
		}
		dp[1] = "SK";
		dp[2] = "CY";
		dp[3] = "SK";
		for (int i = 4; i <= N; i++) {
			if (dp[i - 1].equals("SK") || dp[i - 3].equals("SK")) {
				dp[i] = "CY";
			} else {
				dp[i] = "SK";
			}

		}
		System.out.println(dp[N]);
	}

}