import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();

		int a_cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			if (cur == 'a')
				a_cnt++;
		}

		String target = s.substring(0, a_cnt);
		int b_cnt = 0;
		for (int i = 0; i < target.length(); i++) {
			char cur = target.charAt(i);
			if (cur == 'b')
				b_cnt++;
		}
		int ans = b_cnt;

		for (int i = 0; i < s.length(); i++) {
			int front = i;
			int back = i + a_cnt;
			if (back >= s.length())
				back -= s.length();
			if (s.charAt(front) == 'b')
				b_cnt--;
			if (s.charAt(back) == 'b')
				b_cnt++;
			ans = Math.min(ans, b_cnt);
		}
		System.out.println(ans);
	}
}