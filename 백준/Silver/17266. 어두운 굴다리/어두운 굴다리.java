import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;

	static int[] locate;

	private static boolean check(int range) {
		int last = 0;
		for (int i = 0; i < M; i++) {
			if (locate[i] - range > last) {
				return false;
			}
			last = locate[i] + range;
			if (last >= N) {
				return true;
			}
		}
		return last >= N;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		locate = new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			locate[i] = Integer.parseInt(st.nextToken());
		}
		int min = 1;
		int max = N;

		int ans = 0;
		while (min <= max) {
			int mid = (min + max) / 2;
			if (check(mid)) {
				ans = mid;
				max = mid - 1;
			} else
				min = mid + 1;
		}

		System.out.println(ans);
	}

}