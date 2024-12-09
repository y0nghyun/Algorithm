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

	// 전체 초밥 리스트
	static int[] belt;
	// 이미 먹은 초밥인지 여부
	static boolean[] isEaten;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		belt = new int[n];
		isEaten = new boolean[d + 1];
		for (int i = 0; i < n; i++) {
			belt[i] = Integer.parseInt(br.readLine());
		}

		int max = 0;
		// 접시 개수만큼
		for (int i = 0; i < n; i++) {
			int cnt = 0;
			// 연속해서 먹는 접시의 수만큼
			for (int j = 0; j < k; j++) {
				int temp = i + j;
				// 만약 배열을 벗어나면 다시 앞으로
				if (temp >= n)
					temp -= n;
				// 아직 먹지 않은 초밥이라면 개수 ++ , 먹었다고 체크
				if (!isEaten[belt[temp]]) {
					cnt++;
					isEaten[belt[temp]] = true;
				}
			}
			// 쿠폰 사용
			if (!isEaten[c])
				cnt++;
			max = Math.max(cnt, max);
			// 먹었는지 여부 초기화
			Arrays.fill(isEaten, false);
		}
		System.out.println(max);
	}

}