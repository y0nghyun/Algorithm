import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static class Magnet {
		int[] point;
		int right;
		int left;
		int isRotate;

		public Magnet() {
			point = new int[8];
			this.right = 2;
			this.left = 6;
			this.isRotate = 0;
		}
	}

	static int K;
	static Magnet[] magnets;

	private static void order(int magnetIdx, int dir) {
		magnets[magnetIdx].isRotate = dir;
		for (int i = magnetIdx; i >= 1; i--) {
			if (magnets[i].isRotate == 0)
				break;
			rotate(i, i - 1, magnets[i].isRotate);
		}
		for (int i = magnetIdx; i < 3; i++) {
			if (magnets[i].isRotate == 0)
				break;
			rotate(i, i + 1, magnets[i].isRotate);
		}

		for (int i = 0; i < 4; i++) {
			changeIdx(i, magnets[i].isRotate);
		}
	}

	private static void rotate(int cur, int next, int dir) {
		if (cur < next) {
			if (magnets[cur].point[magnets[cur].right] != magnets[next].point[magnets[next].left]) {
				magnets[next].isRotate = -dir;
			} else {
				magnets[next].isRotate = 0;
			}
		} else {
			if (magnets[cur].point[magnets[cur].left] != magnets[next].point[magnets[next].right]) {
				magnets[next].isRotate = -dir;
			} else {
				magnets[next].isRotate = 0;
			}
		}
	}

	private static void changeIdx(int magnetIdx, int dir) {
		if (dir == 0)
			return;
		if (dir == 1) {
			magnets[magnetIdx].left--;
			if (magnets[magnetIdx].left < 0)
				magnets[magnetIdx].left = 7;
			magnets[magnetIdx].right--;
			if (magnets[magnetIdx].right < 0)
				magnets[magnetIdx].right = 7;
		} else if (dir == -1) {
			magnets[magnetIdx].left++;
			if (magnets[magnetIdx].left > 7)
				magnets[magnetIdx].left = 0;
			magnets[magnetIdx].right++;
			if (magnets[magnetIdx].right > 7)
				magnets[magnetIdx].right = 0;
		}
		magnets[magnetIdx].isRotate = 0;
	}

	private static int checkScore() {
		int ans = 0;
		for (int i = 0; i < 4; i++) {
			int idx = magnets[i].right - 2;
			if (idx < 0) {
				idx = 6 + magnets[i].right;
			}
			if (magnets[i].point[idx] == 1) {
				ans += Math.pow(2, i);
			}
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tNum = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= tNum; TC++) {
			K = Integer.parseInt(br.readLine());

			magnets = new Magnet[4];
			for (int i = 0; i < 4; i++) {
				magnets[i] = new Magnet();
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					magnets[i].point[j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < K; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int idx = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());

				order(idx - 1, dir);
			}
			System.out.println("#" + TC + " " + checkScore());

		}

	}

}