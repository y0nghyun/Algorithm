import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static int N;
	static int M;

	static int map[][];
	static Point[] selected;
	static boolean[][] visited;
	static int ans;

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	private static void find(int cnt, Point cur) {
		if (cnt == 4) {
			int sum = 0;
			for (int i = 0; i < selected.length; i++) {
				sum += map[selected[i].x][selected[i].y];
			}
			ans = Math.max(ans, sum);
			return;
		}
		int x = cur.x;
		int y = cur.y;
		if (cnt == 2) {
			int sum = 0;
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for (int i = 0; i < 2; i++) {
				sum += map[selected[i].x][selected[i].y];
			}
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny])
					continue;
				temp.add(map[nx][ny]);
			}
			if (temp.size() == 2) {
				sum += temp.get(0) + temp.get(1);
				ans = Math.max(ans, sum);
			}
			if (temp.size() == 3) {
				sum += Math.max(Math.max(temp.get(0) + temp.get(1), temp.get(0) + temp.get(2)),
						temp.get(1) + temp.get(2));
				ans = Math.max(ans, sum);
			}
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny])
				continue;
			selected[cnt] = new Point(nx, ny);
			visited[nx][ny] = true;
			find(cnt + 1, new Point(nx, ny));
			visited[nx][ny] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		ans = 0;
		selected = new Point[4];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				Point target = new Point(i, j);
				selected[0] = target;
				find(1, target);
				visited[i][j] = false;
			}
		}
		System.out.println(ans);
	}

}