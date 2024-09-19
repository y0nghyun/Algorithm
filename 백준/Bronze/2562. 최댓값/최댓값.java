import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int max = 0;
		int idx = 0;
		for (int i = 0; i < 9; i++) {
			int temp = sc.nextInt();
			if (temp > max) {
				max = temp;
				idx = i;
			}
		}
		System.out.println(max);
		System.out.println(idx + 1);
	}

}