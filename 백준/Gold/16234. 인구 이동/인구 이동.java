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

	static int N;
	static int L;
	static int R;

	static int[][] map;
	static boolean[][] visited;
	static boolean flag;
	static Queue<Point> union;

	static int ans;

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	private static void findUnion(Point cur) {
		Queue<Point> q = new ArrayDeque<>();
		int cnt = 0;
		int sum = 0;

		q.add(cur);
		visited[cur.x][cur.y] = true;
		while (!q.isEmpty()) {
			Point target = q.poll();
			int tx = target.x;
			int ty = target.y;
			union.add(target);
			cnt++;
			sum += map[tx][ty];
			for (int i = 0; i < 4; i++) {
				int nx = tx + dx[i];
				int ny = ty + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny])
					continue;
				int diff = Math.abs(map[tx][ty] - map[nx][ny]);
				if (diff >= L && diff <= R) {
					q.add(new Point(nx, ny));
					visited[nx][ny] = true;
				}
			}
		}
		if (union.size() > 1) {
			flag = true; // 이동 여부 체크
			int newPop = sum / cnt; // 연합 인구 수
			while (!union.isEmpty()) {
				Point temp = union.poll();
				map[temp.x][temp.y] = newPop;
			}
		} else {
			union.poll();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ans = 0;
		union = new ArrayDeque<>();
		while (true) {
			flag = false;
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) // 방문하지 않은 경우만
						findUnion(new Point(i, j));
				}
			}
			if (!flag)
				break;
			ans++;
		}
		System.out.println(ans);
	}
}