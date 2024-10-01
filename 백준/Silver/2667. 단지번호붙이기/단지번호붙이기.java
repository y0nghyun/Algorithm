import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
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
	static int[][] graph;
	static boolean[][] visited;
	static ArrayList<Integer> ans;

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	private static void findApt(int x, int y) {
		if (visited[x][y] || graph[x][y] == 0)
			return;
		visited[x][y] = true;
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(x, y));
		int cnt = 1;
		while (!q.isEmpty()) {
			Point target = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = target.x + dx[i];
				int ny = target.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] || graph[nx][ny] == 0)
					continue;
				q.add(new Point(nx, ny));
				visited[nx][ny] = true;
				cnt++;
			}
		}
		ans.add(cnt);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		graph = new int[N][N];
		visited = new boolean[N][N];
		ans = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			String S = br.readLine();
			for (int j = 0; j < N; j++) {
				graph[i][j] = S.charAt(j) - '0';
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				findApt(i, j);
			}
		}
		Collections.sort(ans);
		System.out.println(ans.size());
		for (int i = 0; i < ans.size(); i++)
			System.out.println(ans.get(i));
	}

}