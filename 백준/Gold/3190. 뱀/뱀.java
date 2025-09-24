import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static class Snake {
		int dir;
		ArrayList<Point> body;

		public Snake(int dir, ArrayList<Point> body) {
			this.dir = dir;
			this.body = body;
		}
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int n;

	static int[][] board;

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());

		board = new int[n][n];

		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			board[x - 1][y - 1] = 2;
		}
		String[] op = new String[10001];
		int l = Integer.parseInt(br.readLine());
		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			op[time] = dir;
		}

		board[0][0] = 1;
		ArrayList<Point> init = new ArrayList<>();
		init.add(new Point(0, 0));
		Snake snake = new Snake(0, init);
		int answer = 1;
		while (true) {
			Point head = snake.body.get(0);
			int nx = head.x + dx[snake.dir];
			int ny = head.y + dy[snake.dir];
			if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1) // 게임이 끝나는 경우
				break;
			if (board[nx][ny] == 2) { // 사과가 있는 경우
				snake.body.add(0, new Point(nx, ny));
				board[nx][ny] = 1;
			} else { // 사과가 없는 경우
				snake.body.add(0, new Point(nx, ny));
				Point target = snake.body.get(snake.body.size() - 1);
				board[target.x][target.y] = 0;
				snake.body.remove(snake.body.size() - 1);
				board[nx][ny] = 1;
			}
			if (op[answer] != null) {
				if (op[answer].equals("L")) {
					snake.dir--;
					if (snake.dir < 0)
						snake.dir = 3;
				} else if (op[answer].equals("D")) {
					snake.dir++;
					if (snake.dir > 3)
						snake.dir = 0;
				}
			}
			answer++;
		}
		System.out.println(answer);
	}

}
