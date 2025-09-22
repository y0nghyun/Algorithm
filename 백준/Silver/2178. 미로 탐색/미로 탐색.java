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

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int graph[][] = new int[N][M];
		for (int i = 0; i < N; i++) {
			String S = br.readLine();
			for (int j = 0; j < M; j++) {
				graph[i][j] = S.charAt(j) - '0';
			}
		}
		Queue<Point> q = new ArrayDeque<>();
		q.offer(new Point(0, 0));
		while (!q.isEmpty()) {
			Point target = q.poll();
			int x = target.x;
			int y = target.y;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && graph[nx][ny] != 0) {
					if (graph[nx][ny] == 1) {
						graph[nx][ny] = graph[x][y] + 1;
						q.offer(new Point(nx, ny));
					} else if (graph[nx][ny] > graph[x][y] + 1) {
						graph[nx][ny] = graph[x][y] + 1;
						q.offer(new Point(nx, ny));
					}
				}
			}
		}
		System.out.println(graph[N - 1][M - 1]);
	}

}