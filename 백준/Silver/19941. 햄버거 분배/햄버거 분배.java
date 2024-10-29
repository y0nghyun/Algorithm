import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int K;
	static char[] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		String s = br.readLine();
		map = new char[N];
		for (int i = 0; i < N; i++) {
			map[i] = s.charAt(i);
		}

		int ans = 0;
		for (int i = 0; i < N; i++) {
			if (map[i] == 'P') {
				for (int j = -K; j <= K; j++) {
					int idx = i + j;
					if (idx < 0 || idx >= N)
						continue;
					if (map[idx] == 'H') {
						ans++;
						map[idx] = 'E';
						break;
					}
				}
			}
		}
		System.out.println(ans);
	}

}