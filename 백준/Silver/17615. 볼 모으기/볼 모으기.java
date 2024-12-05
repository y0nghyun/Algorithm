import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String balls = br.readLine();

		int redCount = 0, blueCount = 0;

		for (char ball : balls.toCharArray()) {
			if (ball == 'R')
				redCount++;
			else if (ball == 'B')
				blueCount++;
		}

		int minMoves = Integer.MAX_VALUE;

		minMoves = Math.min(minMoves, calculateMoves(balls, 'R', redCount, true));

		minMoves = Math.min(minMoves, calculateMoves(balls, 'R', redCount, false));

		minMoves = Math.min(minMoves, calculateMoves(balls, 'B', blueCount, true));

		minMoves = Math.min(minMoves, calculateMoves(balls, 'B', blueCount, false));

		System.out.println(minMoves);
	}

	private static int calculateMoves(String balls, char color, int totalColorCount, boolean toLeft) {
		int moves = 0;
		int count = 0;

		if (toLeft) {
			for (int i = 0; i < balls.length(); i++) {
				if (balls.charAt(i) == color)
					count++;
				else
					break;
			}
		} else {
			for (int i = balls.length() - 1; i >= 0; i--) {
				if (balls.charAt(i) == color)
					count++;
				else
					break;
			}
		}

		moves = totalColorCount - count;
		return moves;
	}
}