import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;
	static int h;

	static int ans;

	static boolean[][] isConnect;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		isConnect = new boolean[h][n];

		ans = 4;

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			isConnect[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = true;
		}

		if (checkLines()) {
			System.out.println(0);
			return;
		}
		addLine(0, 0);
		if (ans > 3)
			System.out.println(-1);
		else
			System.out.println(ans);
	}

	private static void addLine(int idx, int cnt) {
		if (cnt >= 3)
			return;
		for (int i = idx; i < n * h; i++) {
			int x = i / n;
			int y = i % n;
			if (y - 1 >= 0 && isConnect[x][y - 1] || y + 1 < n && isConnect[x][y + 1])
				continue;
			if (y == n - 1)
				continue;
			if (isConnect[x][y])
				continue;
			isConnect[x][y] = true;
			if (checkLines()) {
				ans = Math.min(cnt + 1, ans);
			}
			addLine(idx + 1, cnt + 1);
			isConnect[x][y] = false;
		}

	}

	private static boolean checkLines() {
		for (int i = 0; i < n; i++) {
			int cur = i;
			for (int j = 0; j < h; j++) {
				if (cur - 1 >= 0 && isConnect[j][cur - 1])
					cur--;
				else if (isConnect[j][cur])
					cur++;
			}
			if (cur != i)
				return false;
		}
		return true;

	}
}
