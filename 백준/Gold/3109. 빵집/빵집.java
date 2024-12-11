import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R;
	static int C;

	static char[][] graph; // 맵
	static boolean[][] visited; // 방문 여부

	static int ans;

	static int[] dx = { -1, 0, 1 };
	static int[] dy = { 1, 1, 1 };

	private static boolean findRoute(int x, int y) {
		visited[x][y] = true;

		// 마지막 열에 도달한 경우
		if (y == C - 1) {
			ans++;
			return true;
		}

		// 세 방향 탐색
		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < R && ny < C && !visited[nx][ny] && graph[nx][ny] != 'x') {
				if (findRoute(nx, ny)) {
					return true;
				}
			}
		}

		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		graph = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				graph[i][j] = input.charAt(j);
			}
		}

		ans = 0;
		for (int i = 0; i < R; i++) {
			findRoute(i, 0);
		}

		System.out.println(ans);
	}
}