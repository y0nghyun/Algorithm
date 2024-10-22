import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	static String password;
	static Set<Character> vowels = new HashSet<>();

	static {
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
	}

	private static boolean rule1() {
		for (char c : password.toCharArray()) {
			if (vowels.contains(c)) {
				return true;
			}
		}
		return false;
	}

	private static boolean rule2() {
		boolean isVowel = vowels.contains(password.charAt(0));
		int cnt = 1;

		for (int i = 1; i < password.length(); i++) {
			char curChar = password.charAt(i);
			boolean curIsVowel = vowels.contains(curChar);

			if (isVowel == curIsVowel) {
				cnt++;
				if (cnt >= 3) {
					return false;
				}
			} else {
				cnt = 1;
			}
			isVowel = curIsVowel;
		}
		return true;
	}

	private static boolean rule3() {
		char prev = password.charAt(0);

		for (int i = 1; i < password.length(); i++) {
			char cur = password.charAt(i);
			if (prev == cur && cur != 'e' && cur != 'o') {
				return false;
			}
			prev = cur;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			password = sc.next();
			if (password.equals("end"))
				break;

			if (!rule1()) {
				System.out.println("<" + password + "> is not acceptable.");
				continue;
			}
			if (!rule2()) {
				System.out.println("<" + password + "> is not acceptable.");
				continue;
			}
			if (!rule3()) {
				System.out.println("<" + password + "> is not acceptable.");
				continue;
			}
			System.out.println("<" + password + "> is acceptable.");
		}
		sc.close();
	}
}