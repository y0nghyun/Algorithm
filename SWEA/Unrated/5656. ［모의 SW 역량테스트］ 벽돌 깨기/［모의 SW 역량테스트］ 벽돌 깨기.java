import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int W;
	static int H;
	static int[][] map;
	static int[][] testMap;
	static int[] arr;
	static int ans;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	// 순열 생성
	private static void perm(int idx) {
		if (idx >= N) {
			copyMap();
			for (int i = 0; i < N; i++) {
				logic(arr[i]); // 블록 떨어뜨리기
			}
			int num = checkMap(); // 남은 블록 수 계산
			ans = Math.min(ans, num); // 최소 값 갱신
			return;
		}

		for (int i = 0; i < W; ++i) {
			arr[idx] = i; // 순열 배열에 떨어뜨릴 열 저장
			perm(idx + 1); // 다음 위치 순열 생성
		}
	}

	private static void logic(int idx) {
		visited = new boolean[H][W];
		for (int i = 0; i < H; i++) {
			if (testMap[i][idx] != 0) { // 블록이 있는 위치
				shoot(i, idx); // 블록 터뜨리기
				break;
			}
		}
		arrange(); // 터뜨린 후 블록 정리
	}

	private static void shoot(int x, int y) {
		if (visited[x][y] || testMap[x][y] == 0)
			return; // 이미 방문했거나 빈 공간일 경우 리턴

		int power = testMap[x][y]; // 파괴 범위
		visited[x][y] = true; // 방문 처리
		testMap[x][y] = 0; // 블록 파괴

		// 네 방향으로 퍼져나가며 블록 파괴
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < power; j++) {
				int nx = x + dx[i] * j;
				int ny = y + dy[i] * j;
				if (nx < 0 || ny < 0 || nx >= H || ny >= W)
					continue; // 범위 체크
				shoot(nx, ny); // 재귀적으로 파괴
			}
		}
	}

	private static void arrange() {
		// 블록 아래로 떨어뜨리기
		for (int i = 0; i < W; i++) {
			int[] temp = new int[H];
			int idx = 0;
			// 위에서부터 남은 블록을 temp에 저장
			for (int j = 0; j < H; j++) {
				if (testMap[j][i] != 0) {
					temp[idx] = testMap[j][i];
					idx++;
				}
			}
			// 아래에서부터 채워넣기
			for (int j = H - 1; j >= 0; j--) {
				if (idx > 0) {
					testMap[j][i] = temp[--idx];
				} else {
					testMap[j][i] = 0;
				}
			}
		}
	}

	// 원본 map을 testMap에 복사
	private static void copyMap() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				testMap[i][j] = map[i][j];
			}
		}
	}

	// 남아 있는 블록의 개수 세기
	private static int checkMap() {
		int cnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (testMap[i][j] != 0)
					cnt++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tNum = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= tNum; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 떨어뜨릴 횟수
			W = Integer.parseInt(st.nextToken()); // 너비
			H = Integer.parseInt(st.nextToken()); // 높이

			ans = Integer.MAX_VALUE;
			map = new int[H][W];
			testMap = new int[H][W];
			arr = new int[N];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			perm(0); // 순열 생성 및 탐색 시작
			System.out.println("#" + TC + " " + ans);
		}
	}
}