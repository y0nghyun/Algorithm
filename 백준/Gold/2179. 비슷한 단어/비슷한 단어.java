import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		ArrayList<String> words = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			words.add(br.readLine());
		}

		int maxLen = 0;
		int idx1 = 0, idx2 = 0;

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				int len = checkCommon(words.get(i), words.get(j));

				// 더 긴 거일 때
				if (len > maxLen) {
					maxLen = len;
					idx1 = i;
					idx2 = j;
				}
				// 길이가 같을 때
				else if (len == maxLen) {
					// 첫번째거 보다 작거나 첫번째거 같아도 두번째거가 더 작을 때
					if (idx1 > i || (idx1 == i && idx2 > j)) {
						idx1 = i;
						idx2 = j;
					}
				}
			}
		}

		System.out.println(words.get(idx1));
		System.out.println(words.get(idx2));
	}

	private static int checkCommon(String s1, String s2) {
		int len = Math.min(s1.length(), s2.length());
		int cnt = 0;
		for (int i = 0; i < len; i++) {
			if (s1.charAt(i) == s2.charAt(i)) {
				cnt++;
			} else {
				break;
			}
		}
		return cnt;
	}
}