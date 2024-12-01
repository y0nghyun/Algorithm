import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] count = new int[100001];
		int start = 0;
		int end = 0;
		int maxLen = 0;

		while (end < N) {
			count[arr[end]]++;

			while (count[arr[end]] > K) {
				count[arr[start]]--;
				start++;
			}

			maxLen = Math.max(end - start + 1, maxLen);
			end++;
		}
		System.out.println(maxLen);
	}

}