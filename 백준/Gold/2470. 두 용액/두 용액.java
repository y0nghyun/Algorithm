import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static long[] liquid;
	static long ans1;
	static long ans2;
	static long sum;

	private static void search(int a, int b) {
		if (a >= b)
			return;

		if (liquid[a] + liquid[b] == 0) {
			ans1 = liquid[a];
			ans2 = liquid[b];
			return;
		}
		if (sum > Math.abs(liquid[a] + liquid[b])) {
			sum = Math.abs(liquid[a] + liquid[b]);
			ans1 = liquid[a];
			ans2 = liquid[b];
		}
		if (Math.abs(liquid[a + 1] + liquid[b]) < Math.abs(liquid[a] + liquid[b - 1])) {
			search(a + 1, b);
		} else {
			search(a, b - 1);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		liquid = new long[N];

		for (int i = 0; i < N; i++) {
			liquid[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(liquid);
		sum = Math.abs(liquid[0] + liquid[N - 1]);
		ans1 = liquid[0];
		ans2 = liquid[N - 1];
		search(0, N - 1);
		System.out.println(ans1 + " " + ans2);

	}

}