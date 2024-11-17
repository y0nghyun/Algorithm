import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] heights = new int[1001];
		int start = 1001;
		int end = 0;
		int maxHeight = 0;
		int maxIndex = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			heights[x] = y;
			start = Math.min(start, x);
			end = Math.max(end, x);

			if (maxHeight < y) {
				maxHeight = y;
				maxIndex = x;
			}
		}

		int area = 0;
		int leftMaxHeight = 0;
		for (int i = start; i <= maxIndex; i++) {
			leftMaxHeight = Math.max(leftMaxHeight, heights[i]);
			area += leftMaxHeight;
		}

		int rightMaxHeight = 0;
		for (int i = end; i > maxIndex; i--) {
			rightMaxHeight = Math.max(rightMaxHeight, heights[i]);
			area += rightMaxHeight;
		}

		System.out.println(area);
	}
}