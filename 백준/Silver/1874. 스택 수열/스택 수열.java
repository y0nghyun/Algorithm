import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		Stack<Integer> nums = new Stack<Integer>();
		boolean[] used = new boolean[n + 1];
		int cur = 1;
		for (int i = 0; i < n; i++) {
			int target = Integer.parseInt(br.readLine());
			if (cur <= target) {
				while (cur <= target) {
					if (cur > n) {
						System.out.println("NO");
						return;
					}
					if (!used[cur]) {
						used[cur] = true;
						nums.add(cur);
						sb.append('+').append('\n');
					}
					cur++;
				}
			}
			if (nums.isEmpty()) {
				System.out.println("NO");
				return;
			}
			if (nums.pop() == target) {
				sb.append('-').append('\n');
				cur--;
			} else {
				System.out.println("NO");
				return;
			}

		}
		System.out.println(sb);
	}

}