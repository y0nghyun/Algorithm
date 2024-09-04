import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int S;
	static int[] arr;

	private static int solve() {
		int ans = Integer.MAX_VALUE;
		int left = 0, right = 0, sum = 0;

		while (true) {
			// 합이 S 이상이면 최소 길이 갱신하고 left 포인터를 옮겨서 부분합을 줄임
			if (sum >= S) {
				ans = Math.min(ans, right - left);
				sum -= arr[left++];
			}
			// right 포인터를 옮겨서 부분합을 증가시킴
			else if (right == N) {
				break;
			} else {
				sum += arr[right++];
			}
		}

		// 가능한 최소 길이를 찾지 못한 경우 0을 출력
		return ans == Integer.MAX_VALUE ? 0 : ans;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int ans = solve();
		System.out.println(ans);
	}

}