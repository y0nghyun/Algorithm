import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
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

	static int n;
	static int m;
	static char[][] map;

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	static boolean[][] visited;
	static Point cur;
	static int ans;

	private static void find() {
		int x = cur.x;
		int y = cur.y;

		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(x, y));
		visited[x][y] = true;

		while (!q.isEmpty()) {
			Point target = q.poll();
			int tx = target.x;
			int ty = target.y;

			for (int i = 0; i < 4; i++) {
				int nx = tx + dx[i];
				int ny = ty + dy[i];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || map[nx][ny] == 'X')
					continue;
				visited[nx][ny] = true;
				if (map[nx][ny] == 'P')
					ans++;
				q.add(new Point(nx, ny));
			}

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][m];
		visited = new boolean[n][m];
		ans = 0;

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'I') {
					cur = new Point(i, j);
				}
			}
		}
		find();
		if (ans == 0) {
			System.out.println("TT");
			return;
		}
		System.out.println(ans);

	}

}