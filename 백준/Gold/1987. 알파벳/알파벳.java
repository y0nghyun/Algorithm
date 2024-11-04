import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R;
	static int C;

	static char[][] map;
	static boolean[] Alphabet;

	static int ans;

	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		Alphabet = new boolean[26];
		ans = 0;
		for (int i = 0; i < R; i++) {
			String S = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = S.charAt(j);
			}
		}
		Alphabet[map[0][0] - 'A'] = true;
		findRoute(0, 0, 1);
		System.out.println(ans);
	}

	private static void findRoute(int x, int y, int cnt) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < R && ny >= 0 && ny < C && Alphabet[map[nx][ny] - 'A'] != true) {
				Alphabet[map[nx][ny] - 'A'] = true;
				findRoute(nx, ny, cnt + 1);
				Alphabet[map[nx][ny] - 'A'] = false;
			}
		}
		ans = Math.max(ans, cnt);
	}
}