import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static class Board {
		int[][] nums;

		public Board(int[][] nums) {
			this.nums = nums;
		}
	}

	static int n;
	static int answer;
	static Board[] boards;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		int[][] nums = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
				answer = Math.max(answer, nums[i][j]);
			}
		}

		boards = new Board[6]; // 0~5 깊이
		boards[0] = new Board(nums);
		dfs(1);
		System.out.println(answer);
	}

	static void dfs(int cnt) {
		if (cnt > 5)
			return;
		for (int dir = 0; dir < 4; dir++) {
			moveBlocks(dir, cnt);
			dfs(cnt + 1);
		}
	}

	// dir: 0=좌, 1=우, 2=상, 3=하
	static void moveBlocks(int type, int cnt) {
		int[][] prev = boards[cnt - 1].nums;
		int[][] curBoard = new int[n][n];

		if (type == 0) { // LEFT
			for (int i = 0; i < n; i++) {
				int idx = 0;
				int curNum = 0; // ★ 행마다 초기화
				for (int j = 0; j < n; j++) {
					int v = prev[i][j];
					if (v == 0)
						continue;
					if (curNum == 0) {
						curNum = v;
					} else if (curNum == v) {
						curBoard[i][idx++] = curNum * 2;
						answer = Math.max(answer, curNum * 2); // ★ 대입
						curNum = 0;
					} else {
						curBoard[i][idx++] = curNum;
						curNum = v;
					}
				}
				// ★ 남은 curNum 밀어넣기
				if (curNum != 0)
					curBoard[i][idx] = curNum;
			}
		} else if (type == 1) { // RIGHT
			for (int i = 0; i < n; i++) {
				int idx = n - 1;
				int curNum = 0; // ★ 행마다 초기화
				for (int j = n - 1; j >= 0; j--) {
					int v = prev[i][j];
					if (v == 0)
						continue;
					if (curNum == 0) {
						curNum = v;
					} else if (curNum == v) {
						curBoard[i][idx--] = curNum * 2;
						answer = Math.max(answer, curNum * 2);
						curNum = 0;
					} else {
						curBoard[i][idx--] = curNum;
						curNum = v;
					}
				}
				if (curNum != 0)
					curBoard[i][idx] = curNum;
			}
		} else if (type == 2) { // UP
			for (int j = 0; j < n; j++) {
				int idx = 0;
				int curNum = 0; // ★ 열마다 초기화
				for (int i = 0; i < n; i++) {
					int v = prev[i][j];
					if (v == 0)
						continue;
					if (curNum == 0) {
						curNum = v;
					} else if (curNum == v) {
						curBoard[idx++][j] = curNum * 2;
						answer = Math.max(answer, curNum * 2);
						curNum = 0;
					} else {
						curBoard[idx++][j] = curNum;
						curNum = v;
					}
				}
				if (curNum != 0)
					curBoard[idx][j] = curNum;
			}
		} else { // DOWN (type == 3)
			for (int j = 0; j < n; j++) {
				int idx = n - 1;
				int curNum = 0; // ★ 열마다 초기화
				for (int i = n - 1; i >= 0; i--) {
					int v = prev[i][j];
					if (v == 0)
						continue;
					if (curNum == 0) {
						curNum = v;
					} else if (curNum == v) {
						curBoard[idx--][j] = curNum * 2;
						answer = Math.max(answer, curNum * 2);
						curNum = 0;
					} else {
						curBoard[idx--][j] = curNum;
						curNum = v;
					}
				}
				if (curNum != 0)
					curBoard[idx][j] = curNum;
			}
		}

		// (선택) 최댓값 한 번 더 점검 – 합치기 외에 단순 이동 후의 값 포함
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				answer = Math.max(answer, curBoard[i][j]);

		boards[cnt] = new Board(curBoard);
	}
}
