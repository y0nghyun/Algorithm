import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int Y = sc.nextInt();
		int Z = (int) ((long) (Y) * 100 / (X));

		int answer = -1;
		int left = 0;
		int right = (int) 1e9;
		while (left <= right) {
			int mid = (left + right) / 2;
			int cur = (int) ((long) (Y + mid) * 100 / (X + mid));
			if (cur != Z) {
				answer = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(answer);
	}

}