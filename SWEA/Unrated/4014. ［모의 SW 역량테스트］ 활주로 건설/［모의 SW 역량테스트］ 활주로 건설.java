import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int L;

	static int[][] map;
	static boolean[] slope;

	private static int checkMap() {
		int cnt = 0;
		for (int i = 0; i < N; i++) { // 열 확인
			slope = new boolean[N];
			for (int j = 0; j < N - 1; j++) {
				if (map[i][j] < map[i][j + 1]) {
					if (map[i][j + 1] - map[i][j] > 1) {
						cnt--;
						break;
					}
					if (L == 1) {
						if (slope[j]) {
							cnt--;
							break;
						}
						slope[j] = true;
					}
					if (!checkcolUp(i, j)) {
						cnt--;
						break;
					}
				} else if (map[i][j] > map[i][j + 1]) {
					if (map[i][j] - map[i][j + 1] > 1) {
						cnt--;
						break;
					}
					if (L == 1) {
						slope[j + 1] = true;
						continue;
					}
					if (!checkcolDown(i, j + 1)) {
						cnt--;
						break;
					}
				}
			}
			cnt++;
		}
		for (int i = 0; i < N; i++) { // 행 확인
			slope = new boolean[N];
			for (int j = 0; j < N - 1; j++) {
				if (map[j][i] < map[j + 1][i]) {
					if (map[j + 1][i] - map[j][i] > 1) {
						cnt--;
						break;
					}
					if (L == 1) {
						if (slope[j]) {
							cnt--;
							break;
						}
						slope[j] = true;
					}
					if (!checkrowUp(j, i)) {
						cnt--;
						break;
					}
				} else if (map[j][i] > map[j + 1][i]) {
					if (map[j][i] - map[j + 1][i] > 1) {
						cnt--;
						break;
					}
					if (!checkrowDown(j + 1, i)) {
						if (L == 1) {
							slope[j + 1] = true;
							continue;
						}
						cnt--;
						break;
					}
				}
			}
			cnt++;
		}
		return cnt;
	}

	private static boolean checkcolUp(int x, int y) {
		int temp = map[x][y];
		for (int i = 1; i < L; i++) {
			if (y - i < 0)
				return false;
			if (map[x][y - i] != temp)
				return false;
			if (slope[y - i])
				return false;
		}
		for (int i = y; i > y - L; i--) {
			slope[i] = true;
		}
		return true;
	}

	private static boolean checkcolDown(int x, int y) {
		int temp = map[x][y];
		for (int i = 1; i < L; i++) {
			if (y + i > N - 1)
				return false;
			if (map[x][y + i] != temp)
				return false;
		}
		for (int i = y; i < y + L; i++) {
			slope[i] = true;
		}
		return true;
	}

	private static boolean checkrowUp(int x, int y) {
		int temp = map[x][y];
		for (int i = 1; i < L; i++) {
			if (x - i < 0)
				return false;
			if (map[x - i][y] != temp)
				return false;
			if (slope[x - i])
				return false;
		}
		for (int i = x; i > x - L; i--) {
			slope[i] = true;
		}
		return true;
	}

	private static boolean checkrowDown(int x, int y) {
		int temp = map[x][y];
		for (int i = 1; i < L; i++) {
			if (x + i > N - 1)
				return false;
			if (map[x + i][y] != temp)
				return false;
		}
		for (int i = x; i < x + L; i++) {
			slope[i] = true;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tNum = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= tNum; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int ans = checkMap();
			System.out.println("#" + TC + " " + ans);
		}

	}
}