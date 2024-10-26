import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] cost;
	static int[] price;
	static int[] total;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		cost = new int[N - 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}

		price = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}

		total = new int[N];
		total[0] = 0;
		total[1] = cost[0] * price[0];
		for (int i = 2; i < N; i++) {
			int minPrice = Integer.MAX_VALUE;
			for (int j = i - 1; j >= 0; j--) {
				minPrice = Math.min(minPrice, price[j]);
			}
			total[i] = total[i - 1] + minPrice * cost[i - 1];
		}
		System.out.println(total[N - 1]);
	}

}