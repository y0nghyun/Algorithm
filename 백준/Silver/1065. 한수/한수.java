import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (i < 100) {
				cnt++;
			} else if (i < 1000) {
				int updiff = i / 100 - i % 100 / 10;
				int downdiff = i % 100 / 10 - i / 100;
				if (i % 100 / 10 - i % 10 == updiff || i % 10 - i % 100 / 10 == downdiff) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

}