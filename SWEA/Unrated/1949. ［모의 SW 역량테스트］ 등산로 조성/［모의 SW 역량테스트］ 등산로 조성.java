import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static int N;
	static int K;

	static int[][] map;

	static ArrayList<Point> high;
	static int ans;

	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static boolean[][] visited;

	private static void findRoute(int x, int y, int cnt, int num, int k) {
		if (cnt > ans) {
			ans = cnt;
		}
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx >= N || ny >= N)
				continue;
			if (visited[nx][ny])
				continue;
			if (map[nx][ny] < num) {
				visited[nx][ny] = true;
				findRoute(nx, ny, cnt + 1, map[nx][ny], k);
				visited[nx][ny] = false;
			} else {
				if (k == 0) {
					for (int j = 1; j <= K; j++) {
						if (map[nx][ny] - j < num) {
							visited[nx][ny] = true;
							findRoute(nx, ny, cnt + 1, map[nx][ny] - j, k + 1);
							visited[nx][ny] = false;
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tNum = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= tNum; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			high = new ArrayList<>();
			ans = 1;
			visited = new boolean[N][N];

			int maxNum = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					maxNum = Math.max(maxNum, map[i][j]);
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == maxNum) {
						high.add(new Point(i, j));
					}
				}
			}
			for (int i = 0; i < high.size(); i++) {
				visited[high.get(i).x][high.get(i).y] = true;
				findRoute(high.get(i).x, high.get(i).y, 1, map[high.get(i).x][high.get(i).y], 0);
				visited[high.get(i).x][high.get(i).y] = false;
			}
			System.out.println("#" + TC + " " + ans);

		}
	}

}