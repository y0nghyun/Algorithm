import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;

	static boolean[][] graph;
	static boolean[] visited;

	private static void findRoute(int cur) {
		for (int i = 1; i < N + 1; i++) {
			if (graph[cur][i] && !visited[i]) {
				visited[i] = true;
				findRoute(i);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		graph = new boolean[N + 1][N + 1];
		visited = new boolean[N + 1];
		for (int i = 1; i < N + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				int to = Integer.parseInt(st.nextToken());
				if (to == 1)
					graph[i][j] = true;
			}
		}

		int[] plan = new int[M];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			plan[i] = Integer.parseInt(st.nextToken());
		}

		visited[plan[0]] = true;
		findRoute(plan[0]);
		for (int i = 0; i < plan.length; i++) {
			if (!visited[plan[i]]) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

}