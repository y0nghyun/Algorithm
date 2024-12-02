import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		int[] cost = new int[D + 1];
		int[][] fastWay = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			fastWay[i][0] = Integer.parseInt(st.nextToken());
			fastWay[i][1] = Integer.parseInt(st.nextToken());
			fastWay[i][2] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < cost.length; i++) {
			cost[i] = cost[i - 1] + 1;
			for (int j = 0; j < fastWay.length; j++) {
				if (fastWay[j][1] == i) {
					cost[i] = Math.min(cost[i], fastWay[j][2] + cost[fastWay[j][0]]);
				}
			}
		}
		System.out.println(cost[D]);
	}

}