import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();

		int ans = 1;
		int cur = 2;

		if (a == 1)
			System.out.println(1);
		else {
			while (cur <= a) {
				cur += 6 * ans;
				ans++;
			}
			System.out.println(ans);
		}
	}

}