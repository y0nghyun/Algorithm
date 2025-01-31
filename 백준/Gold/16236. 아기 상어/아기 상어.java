import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Point implements Comparable<Point> {
		int x, y, dist;

		public Point(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		@Override // 우선순위 물고기를 정하기 위한
		public int compareTo(Point o) {
			if (this.dist == o.dist) {
				if (this.x == o.x) {
					return this.y - o.y;
				}
				return this.x - o.x;
			}
			return this.dist - o.dist;
		}
	}

	static int N;
	static int[][] graph;
	static boolean[][] visited;
	static Point shark;
	static int fishSize = 2; // 초기 물고기 크기
	static int eatenFish = 0; // 먹은 물고기 개수
	static int ans = 0;

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if (graph[i][j] == 9) {
					shark = new Point(i, j, 0);
					graph[i][j] = 0; // 현재 물고기 자리를 초기화
				}
			}
		}

		while (true) {
			Point fish = findFish(); // 먹을 물고기 위치 찾기
			if (fish == null) // 없으면 끝
				break;

			// 거리 계산 후 상어 위치 변경
			ans += fish.dist; 
			shark = new Point(fish.x, fish.y, 0);
			graph[fish.x][fish.y] = 0;

			// 물고기 사이즈 변경
			eatenFish++;
			if (eatenFish == fishSize) {
				fishSize++;
				eatenFish = 0;
			}
		}

		System.out.println(ans);
	}

	private static Point findFish() {
		Queue<Point> queue = new ArrayDeque<>();
		visited = new boolean[N][N];

		queue.add(new Point(shark.x, shark.y, 0));
		visited[shark.x][shark.y] = true;

		// 가능한 물고기를 넣어줄 리스트
		ArrayList<Point> fishes = new ArrayList<>();

		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] || graph[nx][ny] > fishSize)
					continue;

				visited[nx][ny] = true;
				if (graph[nx][ny] > 0 && graph[nx][ny] < fishSize) {
					fishes.add(new Point(nx, ny, cur.dist + 1));
				}
				queue.add(new Point(nx, ny, cur.dist + 1));
			}
		}

		Collections.sort(fishes);
		if (fishes.isEmpty())
			return null;
		return fishes.get(0);
	}
}