import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static int n;
	static String[] map;
	static Point head;

	private static void findHead() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i].charAt(j) == '*') {
					head = new Point(i, j);
					return;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		map = new String[n];
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine();
		}
		findHead();

		Point heart = null;

		int x = head.x;
		int y = head.y;
		for (int i = 1; i < n; i++) {
			int nx = x + i;
			int ny = y;
			if (map[nx].charAt(ny - 1) != '_') {
				heart = new Point(nx, ny);
				break;
			}
		}
		x = heart.x + 1;
		y = heart.y + 1;
		System.out.println(x + " " + y);

		int cnt = 0;
		for (int i = heart.y - 1; i >= 0; i--) {
			if (map[heart.x].charAt(i) == '*')
				cnt++;
		}
		System.out.print(cnt + " ");

		cnt = 0;
		for (int i = heart.y + 1; i < n; i++) {
			if (map[heart.x].charAt(i) == '*')
				cnt++;
		}
		System.out.print(cnt + " ");

		cnt = 0;
		int wx = 0;
		int wy = heart.y;
		for (int i = heart.x + 1; i < n; i++) {
			if (map[i].charAt(heart.y) == '_') {
				break;
			}
			wx = i;
			cnt++;
		}
		System.out.print(cnt + " ");

		cnt = 0;
		int lx = wx + 1;
		int ly = wy - 1;
		for (int i = lx; i < n; i++) {
			if (map[i].charAt(ly) == '*')
				cnt++;
		}
		System.out.print(cnt + " ");

		cnt = 0;
		lx = wx + 1;
		ly = wy + 1;
		for (int i = lx; i < n; i++) {
			if (map[i].charAt(ly) == '*')
				cnt++;
		}
		System.out.print(cnt + " ");

	}

}