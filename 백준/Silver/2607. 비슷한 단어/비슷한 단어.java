import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static String word;
	static int[] alp;
	static int[] temp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		word = br.readLine();

		alp = new int[26];
		int ans = 0;
		for (int i = 0; i < word.length(); i++) {
			alp[word.charAt(i) - 'A']++;
		}
		temp = new int[26];
		for (int i = 0; i < N - 1; i++) {
			temp = alp.clone();
			String target = br.readLine();
			for (int j = 0; j < target.length(); j++) {
				temp[target.charAt(j) - 'A']--;
			}
			int cnt = -2;
			for (int j = 0; j < temp.length; j++) {
				if (temp[j] != 0)
					cnt += Math.abs(temp[j]);
			}
			cnt += Math.abs(word.length() - target.length());
			if (cnt <= 0)
				ans++;
		}
		System.out.println(ans);

	}

}