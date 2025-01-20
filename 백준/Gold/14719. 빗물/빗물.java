import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		boolean[][] map = new boolean[H][W];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			int block = Integer.parseInt(st.nextToken());
			for (int j = 0; j < block; j++) {
				map[H - 1 - j][i] = true;
			}
		}
		int ans = 0;
		for (int i = 1; i < W - 1; i++) {
			for (int j = 0; j < H; j++) {
				if (map[j][i])
					continue;
				boolean leftFlag = false;
				boolean rightFlag = false;
				for (int k = i - 1; k >= 0; k--) {
					if (map[j][k]) {
						leftFlag = true;
						break;
					}
				}
				for (int k = i + 1; k < W; k++) {
					if (map[j][k]) {
						rightFlag = true;
						break;
					}
				}
				if (leftFlag && rightFlag) {
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
}