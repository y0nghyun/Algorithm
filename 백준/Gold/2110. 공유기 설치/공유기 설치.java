import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int c;
	static int[] iptime;

	private static int count(int num) {
		int cnt = 1;

		int temp = iptime[0];

		for (int i = 1; i < iptime.length; i++) {
			int cur = iptime[i];

			if (cur - temp >= num) {
				cnt++;
				temp = cur;
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		iptime = new int[n];
		for (int i = 0; i < n; i++) {
			iptime[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(iptime);

		int max = iptime[n - 1] - iptime[0] + 1;
		int min = 1;

		while (min < max) {
			int mid = (max + min) / 2;

			if (count(mid) < c) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		System.out.println(min - 1);
	}

}