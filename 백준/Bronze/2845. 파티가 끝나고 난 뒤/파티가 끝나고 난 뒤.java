import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int p = sc.nextInt();

		int num = l * p;
		for (int i = 0; i < 5; i++) {
			int target = sc.nextInt();
			System.out.print(target - num + " ");
		}
	}
}