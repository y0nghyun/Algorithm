import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int n;
	static int k;

	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());

		long min = 1;
		long max = k;

		while (min < max) { // Lower Bound
			long mid = (min + max) / 2;
			long count = 0;

			for (int i = 1; i <= n; i++) {
				count += Math.min(mid / i, n);
			}

			if (k <= count) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		System.out.println(min);

	}

}