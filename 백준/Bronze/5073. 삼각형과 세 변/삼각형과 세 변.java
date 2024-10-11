import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] tri = new int[3];
			int max = 0;
			int idx = 0;
			int sum = 0;
			for (int i = 0; i < 3; i++) {
				tri[i] = Integer.parseInt(st.nextToken());
				if (max < tri[i]) {
					idx = i;
				}
				sum += tri[i];
			}

			if (tri[0] == 0 && tri[1] == 0 && tri[2] == 0)
				break;
			if (tri[0] == tri[1] && tri[1] == tri[2] && tri[0] == tri[2]) {
				System.out.println("Equilateral");
			} else if (tri[idx] >= sum - tri[idx]) {
				System.out.println("Invalid");
			} else {
				if (tri[0] == tri[1] || tri[0] == tri[2] || tri[1] == tri[2]) {
					System.out.println("Isosceles");
				} else {
					System.out.println("Scalene");
				}
			}
		}
	}

}