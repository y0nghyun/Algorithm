import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static String[] chan;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		chan = new String[N];
		int kbs1Idx = 0;
		int kbs2Idx = 0;

		for (int i = 0; i < N; i++) {
			chan[i] = br.readLine();
			if (chan[i].equals("KBS1")) {
				kbs1Idx = i;
			}
		}

		for (int i = 0; i < kbs1Idx; i++) {
			sb.append("1"); //
		}
		for (int i = kbs1Idx; i > 0; i--) {
			swap(i, i - 1);
			sb.append("4"); //
		}

		for (int i = 0; i < N; i++) {
			if (chan[i].equals("KBS2")) {
				kbs2Idx = i;
			}
		}

		for (int i = 0; i < kbs2Idx; i++) {
			sb.append("1");
		}
		for (int i = kbs2Idx; i > 1; i--) {
			swap(i, i - 1);
			sb.append("4");
		}

		System.out.println(sb.toString());
	}

	private static void swap(int a, int b) {
		String temp = chan[a];
		chan[a] = chan[b];
		chan[b] = temp;
	}
}