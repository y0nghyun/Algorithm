import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;
	static int[] money;

	private static int check(int num) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			if (money[i] < num) {
				sum += money[i];
			} else {
				sum += num;
			}
		}

		return sum;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		money = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			money[i] = Integer.parseInt(st.nextToken());
		}

		m = Integer.parseInt(br.readLine());

		Arrays.sort(money);

		int max = money[n - 1] + 1;
		int min = 0;

		while (min < max) {
			int mid = (max + min) / 2;

			int total = 0;
			total = check(mid);

			if (total <= m) {
				min = mid + 1;
			} else {
				max = mid;
			}
		}
		System.out.println(min - 1);

	}

}