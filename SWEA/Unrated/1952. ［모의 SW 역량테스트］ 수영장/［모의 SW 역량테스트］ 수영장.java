import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] pass;
	static int[] plan;
	static int[] cost;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tNum = Integer.parseInt(br.readLine());

		for (int TC = 1; TC <= tNum; TC++) {

			pass = new int[4];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				pass[i] = Integer.parseInt(st.nextToken());
			}

			plan = new int[12];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());

			}

			ans = 0;
			cost = new int[12];
			cost[0] = Math.min(plan[0] * pass[0], pass[1]);
			cost[1] = Math.min(plan[1] * pass[0], pass[1]) + cost[0];
			cost[2] = Math.min(Math.min(plan[2] * pass[0], pass[1]) + cost[1], pass[2]);
			for (int i = 3; i < 12; i++) {
				int curMonthCost = Math.min(plan[i] * pass[0], pass[1]);
				cost[i] = Math.min(cost[i - 1] + curMonthCost, cost[i - 3] + pass[2]);
			}
			cost[11] = Math.min(cost[11], pass[3]);

			System.out.println("#" + TC + " " + cost[11]);

		}
	}

}