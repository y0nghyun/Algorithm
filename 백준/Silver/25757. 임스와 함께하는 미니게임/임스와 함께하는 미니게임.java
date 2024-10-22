import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static Set<String> users = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		String gameType = st.nextToken();
		int num = 0;
		if (gameType.equals("Y"))
			num = 2;
		else if (gameType.equals("F"))
			num = 3;
		else
			num = 4;
		int cnt = 1;
		int ans = 0;
		for (int i = 0; i < N; i++) {
			String user = br.readLine();
			if (!users.contains(user)) {
				users.add(user);
				cnt++;
			}
			if (cnt == num) {
				ans++;
				cnt = 1;
			}
		}
		System.out.println(ans);
	}
}