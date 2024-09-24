import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] arr;
	static int cnt;

	private static void find(int idx) {
		int min = 0;
		int max = arr.length - 1;

		while (min < max) {
			if (min == idx) {
				min++;
				continue;
			}
			if (max == idx) {
				max--;
				continue;
			}
			if (arr[min] + arr[max] == arr[idx]) {
				cnt++;
				return;
			} else if (arr[min] + arr[max] < arr[idx]) {
				min++;
			} else {
				max--;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		cnt = 0;
		for (int i = 0; i < N; i++) {
			find(i);
		}
		System.out.println(cnt);
	}

}