import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();

		int[] cnt = new int[26];
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			char target = s.charAt(i);
			if (target >= 'A' && target <= 'Z') {
				cnt[target - 'A']++;
				if (max < cnt[target - 'A'])
					max = cnt[target - 'A'];
			} else {
				cnt[target - 'a']++;
				if (max < cnt[target - 'a'])
					max = cnt[target - 'a'];
			}
		}
		int maxCnt = 0;
		int idx = 0;
		for (int i = 0; i < 26; i++) {
			if (cnt[i] == max) {
				maxCnt++;
				idx = i;
			}
		}
		if (maxCnt == 1) {
			char ans = (char) ('A' + idx);
			System.out.println(ans);
		} else {
			System.out.println("?");
		}

	}
}