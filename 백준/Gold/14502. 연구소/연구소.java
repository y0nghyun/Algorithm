import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;

	static int[][] map;

	static int ans;

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static ArrayList<Point> virus = new ArrayList<>();
	static int wallCnt;

	static boolean[][] visited;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		wallCnt = 3;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)
					virus.add(new Point(i, j));
				if (map[i][j] == 1)
					wallCnt++;
			}
		}
		ans = 0;
		for (int i = 0; i < n * m; i++) {
			selectWall(i, 0);
		}
		System.out.println(ans);
	}

	public static void selectWall(int idx, int cnt) {
		if (cnt == 3) {
			calculateArea();
			return;
		}
		for (int i = idx; i < n * m; i++) {
			int x = idx / m;
			int y = idx % m;
			if (map[x][y] == 1 || map[x][y] == 2)
				continue;
			map[x][y] = 1;
			selectWall(i + 1, cnt + 1);
			map[x][y] = 0;
		}
	}

	public static void calculateArea() {
		visited = new boolean[n][m];
		Queue<Point> q = new ArrayDeque<>();
		int virusCnt = 0;
		for (Point v : virus) {
			q.add(new Point(v.x, v.y));
			visited[v.x][v.y] = true;
			virusCnt++;
		}
		while (!q.isEmpty()) {
			if (ans > n * m - (virusCnt + wallCnt)) {
				return;
			}
			Point target = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = target.x + dx[i];
				int ny = target.y + dy[i];
				if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || map[nx][ny] == 1)
					continue;
				if (map[nx][ny] == 0) {
					visited[nx][ny] = true;
					virusCnt++;
					q.add(new Point(nx, ny));
				}
			}
		}
		ans = n * m - (virusCnt + wallCnt);

	}

}
