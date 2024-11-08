import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();

		int zeroCnt = 0;
		int oneCnt = 0;
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '0') {
				zeroCnt++;
			} else {
				oneCnt++;
			}
		}
		for (int i = 0; i < zeroCnt / 2; i++) {
			for (int j = S.length() - 1; j >= 0; j--) {
				if (S.charAt(j) == '0') {
					S = S.substring(0, j) + S.substring(j + 1);
					break;
				}
			}
		}
		for (int i = 0; i < oneCnt / 2; i++) {
			for (int j = 0; j < S.length(); j++) {
				if (S.charAt(j) == '1') {
					S = S.substring(0, j) + S.substring(j + 1);
					break;
				}
			}
		}
		System.out.println(S);

	}
}