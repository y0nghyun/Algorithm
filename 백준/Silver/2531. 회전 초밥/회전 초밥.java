import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, d, k, c;
	static int[] belt; // 전체 초밥 리스트
	static int[] isEaten; // 초밥 카운트

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		belt = new int[n];
		isEaten = new int[d + 1];
		for (int i = 0; i < n; i++) {
			belt[i] = Integer.parseInt(br.readLine());
		}

		int max = 0;
		int cnt = 0;

		// 초기 윈도우 설정
		for (int i = 0; i < k; i++) {
			if (isEaten[belt[i]] == 0) {
				cnt++;
			}
			isEaten[belt[i]]++;
		}

		// 쿠폰 확인
		max = (isEaten[c] == 0) ? cnt + 1 : cnt;

		// 슬라이딩 윈도우
		for (int i = 1; i < n; i++) {
			// 새로 추가되는 초밥
			int newSushi = belt[(i + k - 1) % n];
			if (isEaten[newSushi] == 0) {
				cnt++;
			}
			isEaten[newSushi]++;

			// 제거되는 초밥
			int removeSushi = belt[i - 1];
			isEaten[removeSushi]--;
			if (isEaten[removeSushi] == 0) {
				cnt--;
			}

			// 쿠폰 확인
			int temp = (isEaten[c] == 0) ? cnt + 1 : cnt;
			max = Math.max(max, temp);
		}

		System.out.println(max);
	}
}