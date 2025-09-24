import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[] students;
	static int b, c;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		students = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			students[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		long answer = 0;

		for (int i = 0; i < n; i++) {
			answer++;

			int remain = students[i] - b;
			if (remain > 0) {
				answer += (remain + c - 1) / c;
			}
		}

		System.out.println(answer);
	}
}
