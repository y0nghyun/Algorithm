import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();

		boolean[] nums = new boolean[n + 1];
		nums[0] = nums[1] = true;

		for (int i = 2; i <= n; i++) {
			int cnt = 2;
			int j = i * cnt;
			while (j <= n) {
				nums[j] = true;
				cnt++;
				j = i * cnt;
			}
		}
		for (int i = m; i <= n; i++) {
			if (nums[i] == false) {
				System.out.println(i);
			}
		}
	}

}