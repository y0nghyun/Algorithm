import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static class Wheel {
		int[] state;
		int idx;

		public Wheel(int[] state, int idx) {
			this.state = state;
			this.idx = idx;
		}
	}

	static Wheel[] wheels = new Wheel[4];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[][] temp = new int[4][8];
		for (int i = 0; i < 4; i++) {
			String s = br.readLine();
			for (int j = 0; j < 8; j++) {
				temp[i][j] = s.charAt(j) - '0';
			}
			wheels[i] = new Wheel(temp[i], 0);
		}
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			rotateWheel(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));
		}

		int ans = 0;
		for (int i = 0; i < 4; i++) {
			if (wheels[i].state[wheels[i].idx] == 1)
				ans += Math.pow(2, i);
		}
		System.out.println(ans);
	}

	public static void rotateWheel(int num, int dir) {
		boolean[][] isRotate = new boolean[4][2];
		isRotate[num][0] = true;
		isRotate[num][1] = dir == 1 ? true : false;
		for (int i = num; i < 3; i++) {
			if (wheels[i].state[(wheels[i].idx + 2) % 8] != wheels[i + 1].state[(wheels[i + 1].idx + 6) % 8]) {
				isRotate[i + 1][0] = true;
				isRotate[i + 1][1] = isRotate[i][1] ? false : true;
			} else
				break;
		}
		for (int i = num; i > 0; i--) {
			if (wheels[i].state[(wheels[i].idx + 6) % 8] != wheels[i - 1].state[(wheels[i - 1].idx + 2) % 8]) {
				isRotate[i - 1][0] = true;
				isRotate[i - 1][1] = isRotate[i][1] ? false : true;
			} else
				break;
		}
		for (int i = 0; i < 4; i++) {
			if (isRotate[i][0]) {
				wheels[i].idx = isRotate[i][1] ? (wheels[i].idx - 1 + 8) % 8 : (wheels[i].idx + 1) % 8;
			}
		}
	}

}
