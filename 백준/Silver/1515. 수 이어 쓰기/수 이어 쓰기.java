import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();

		int idx = 0;
		int cnt = 1;

		while (idx < n.length()) {
			String cntStr = Integer.toString(cnt);
			for (int i = 0; i < cntStr.length() && idx < n.length(); i++) {
				if (cntStr.charAt(i) == n.charAt(idx)) {
					idx++;
				}
			}
			cnt++;
		}

		System.out.println(cnt - 1);
	}
}