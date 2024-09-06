import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static private class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static final int N = 9;
	static int[][] map;
	static ArrayList<Point> zero;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[N][N];
		zero = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					zero.add(new Point(i, j));
			}
		}
		recur(0);
	}

	private static void recur(int cnt) {
		if (cnt == zero.size()) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			System.exit(0);

		}
		for (int i = 1; i <= 9; i++) {
			if (check(zero.get(cnt).x, zero.get(cnt).y, i)) {
				map[zero.get(cnt).x][zero.get(cnt).y] = i;
				recur(cnt + 1);
				map[zero.get(cnt).x][zero.get(cnt).y] = 0;
			}
		}
	}

	private static boolean check(int x, int y, int num) {
		// 가로 검사
		for (int i = 0; i < N; i++) {
			if (map[x][i] == num)
				return false;
		}
		// 세로 검사
		for (int i = 0; i < N; i++) {
			if (map[i][y] == num)
				return false;
		}
		// 3x3 박스 검사
		int startX = (x / 3) * 3;
		int startY = (y / 3) * 3;
		for (int i = startX; i < startX + 3; i++) {
			for (int j = startY; j < startY + 3; j++) {
				if (map[i][j] == num)
					return false;
			}
		}

		return true;
	}

}