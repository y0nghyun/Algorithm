import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;

	static HashMap<String, Integer> keywords = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			String keyword = br.readLine();
			keywords.put(keyword, 1);
		}
		for (int i = 0; i < M; i++) {
			String used = br.readLine();
			for (int j = 0; j < used.length(); j++) {
				if (used.charAt(j) == ',') {
					String temp = sb.toString();
					if (keywords.containsKey(temp))
						keywords.remove(temp);
					sb.setLength(0);
					continue;
				}
				sb.append(used.charAt(j));
			}
			String temp = sb.toString();
			if (keywords.containsKey(temp))
				keywords.remove(temp);
			sb.setLength(0);
			System.out.println(keywords.size());
		}
	}

}