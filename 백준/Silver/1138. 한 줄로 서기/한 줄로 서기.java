import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] ans = new int[N];
		for (int i = 0; i < N; i++) {
			int count = arr[i];
			for (int j = 0; j < N; j++) {
				if (count == 0 && ans[j] == 0) {
					ans[j] = i + 1; // i + 1은 사람 번호
					break;
				}
				if (ans[j] == 0 || ans[j] > i + 1) {
					if (count > 0) {
						count--;
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			System.out.print(ans[i] + " ");
		}
	}

}