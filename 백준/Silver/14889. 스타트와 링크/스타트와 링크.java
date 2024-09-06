import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] graph;
	static int[] startTeam;
	static int[] linkTeam;
	static int ans;

	private static void combi(int cnt, int num) {
		if (cnt == N / 2) {
			int startScore = 0;
			int linkScore = 0;
			makeLinkTeam();
			for (int i = 0; i < startTeam.length; i++) {
				for (int j = 0; j < startTeam.length; j++) {
					startScore += graph[startTeam[i]][startTeam[j]];
				}
			}
			for (int i = 0; i < linkTeam.length; i++) {
				for (int j = 0; j < linkTeam.length; j++) {
					linkScore += graph[linkTeam[i]][linkTeam[j]];
				}
			}
			ans = Math.min(ans, Math.abs(startScore - linkScore));

			return;

		}

		for (int i = num; i < N; i++) {
			startTeam[cnt] = i;
			combi(cnt + 1, i + 1);
		}
	}

	private static void makeLinkTeam() {
		int cnt = 0;
		int num = 0;
		while (cnt < N / 2) {
			int flag = 0;
			for (int i = 0; i < startTeam.length; i++) {
				if (startTeam[i] == num) {
					flag = 1;
					num++;
					break;
				}
			}
			if (flag == 1)
				continue;
			linkTeam[cnt] = num;
			num++;
			cnt++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		graph = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		startTeam = new int[N / 2];
		linkTeam = new int[N / 2];
		ans = Integer.MAX_VALUE;

		combi(0, 0);
		System.out.println(ans);
	}

}