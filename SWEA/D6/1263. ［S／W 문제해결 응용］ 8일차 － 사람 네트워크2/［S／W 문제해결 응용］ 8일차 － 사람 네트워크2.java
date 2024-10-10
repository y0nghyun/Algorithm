import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int[][] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tNum = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= tNum; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			graph = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
					graph[j][i] = graph[i][j];
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < N; k++) {
						if (i == j || i == k || j == k)
							continue;
						if (graph[j][i] != 0 && graph[i][k] != 0)
							if (graph[j][k] == 0)
								graph[j][k] = graph[j][i] + graph[i][k];
							else
								graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
					}
				}
			}
			int min = Integer.MAX_VALUE;
			int ans = 0;
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					sum += graph[i][j];
				}
				if (sum < min) {
					ans = i;
					min = sum;
				}
			}
			System.out.println("#" + TC + " " + min);
		}
	}

}