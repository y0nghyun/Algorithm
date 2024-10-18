import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int lowBurger = 2000;
		int lowDrink = 2000;
		int h = sc.nextInt();
		lowBurger = Math.min(lowBurger, h);
		int m = sc.nextInt();
		lowBurger = Math.min(lowBurger, m);
		int l = sc.nextInt();
		lowBurger = Math.min(lowBurger, l);
		int co = sc.nextInt();
		lowDrink = Math.min(lowDrink, co);
		int ci = sc.nextInt();
		lowDrink = Math.min(lowDrink, ci);
		System.out.println(lowBurger + lowDrink - 50);
	}

}