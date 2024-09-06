import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static char[] op = { '+', '-', '*', '/' };

	static int N;
	static int[] numlist;
	static int[] oplist;
	static char[] order;
	static int min;
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		numlist = new int[N];
		oplist = new int[4];
		order = new char[N - 1];
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numlist[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			oplist[i] = Integer.parseInt(st.nextToken());
		}

		perm(0);
		System.out.println(max);
		System.out.println(min);
	}

	private static void perm(int cnt) {
		if (cnt == N - 1) {
			int num = calculate();
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (oplist[i] != 0) {
				order[cnt] = op[i];
				oplist[i]--;
				perm(cnt + 1);
				oplist[i]++;
			}

		}

	}

	private static int calculate() {
		int ans = numlist[0];
		for (int i = 1; i < N; i++) {
			switch (order[i - 1]) {
			case '+':
				ans += numlist[i];
				break;
			case '-':
				ans -= numlist[i];
				break;
			case '*':
				ans *= numlist[i];
				break;
			case '/':
				ans /= numlist[i];
				break;
			}
		}
		return ans;
	}

}