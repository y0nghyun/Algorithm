import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int S;
	static int[] arr;

	static int ans;
	static boolean[] isSelected;

	private static void subset(int cnt) {
		if (cnt == N) {
			int sum = 0;
			int selectCnt = 0;
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					sum += arr[i];
					selectCnt++;
				}
			}
			if (selectCnt != 0 && sum == S) {
				ans++;
			}
			return;
		}

		isSelected[cnt] = true;
		subset(cnt + 1);
		isSelected[cnt] = false;
		subset(cnt + 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		arr = new int[N];
		isSelected = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		ans = 0;
		subset(0);

		System.out.println(ans);
	}

}