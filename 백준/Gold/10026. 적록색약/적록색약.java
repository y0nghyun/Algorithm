import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

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
	static char[][] color;
	static char[][] rgcolor;

	static boolean[][] visited;

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	static Queue<Point> q = new ArrayDeque<>();

	private static boolean findNormal(int x, int y) {
		char cur = color[x][y];
		if (visited[x][y])
			return false;
		q.add(new Point(x, y));
		visited[x][y] = true;
		while (!q.isEmpty()) {
			Point target = q.poll();
			int tx = target.x;
			int ty = target.y;

			for (int i = 0; i < 4; i++) {
				int nx = tx + dx[i];
				int ny = ty + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] || color[nx][ny] != cur)
					continue;
				visited[nx][ny] = true;
				q.add(new Point(nx, ny));
			}
		}
		return true;
	}

	private static boolean findRg(int x, int y) {
		char cur = rgcolor[x][y];
		if (visited[x][y])
			return false;
		q.add(new Point(x, y));
		visited[x][y] = true;

		while (!q.isEmpty()) {
			Point target = q.poll();
			int tx = target.x;
			int ty = target.y;

			for (int i = 0; i < 4; i++) {
				int nx = tx + dx[i];
				int ny = ty + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] || rgcolor[nx][ny] != cur)
					continue;
				visited[nx][ny] = true;
				q.add(new Point(nx, ny));
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int cnt = 0;

		color = new char[N][N];
		rgcolor = new char[N][N];
		for (int i = 0; i < N; i++) {
			String S = br.readLine();
			for (int j = 0; j < N; j++) {
				color[i][j] = S.charAt(j);
				rgcolor[i][j] = S.charAt(j);
				if (rgcolor[i][j] == 'G')
					rgcolor[i][j] = 'R';
			}
		}
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (findNormal(i, j))
					cnt++;
			}
		}
		System.out.print(cnt + " ");
		visited = new boolean[N][N];
		cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (findRg(i, j))
					cnt++;
			}
		}
		System.out.println(cnt);

	}
}