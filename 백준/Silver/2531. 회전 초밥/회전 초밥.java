import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int d;
	static int k;
	static int c;

	static int[] belt;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		belt = new int[n];
		check = new boolean[d + 1];
		for (int i = 0; i < n; i++) {
			belt[i] = Integer.parseInt(br.readLine());
		}

		int max = 0;
		for (int i = 0; i < n; i++) {
			int cnt = 0;
			for (int j = 0; j < k; j++) {
				int temp = i + j;
				if (temp >= n)
					temp -= n;
				if (!check[belt[temp]]) {
					cnt++;
					check[belt[temp]] = true;
				}
			}
			if (!check[c])
				cnt++;
			max = Math.max(cnt, max);
			Arrays.fill(check, false);
		}
		System.out.println(max);
	}

}