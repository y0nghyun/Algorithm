import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[] arr;
	static int[] numList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		arr = new int[n];
		numList = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		numList[0] = arr[0];

		int cur = 1;

		for (int i = 1; i < n; i++) {
			int temp = arr[i];
			if (temp > numList[cur - 1]) {
				numList[cur] = temp;
				cur++;
			} else {
				int min = 0;
				int max = cur;
				while (min < max) {
					int mid = (min + max) / 2;
					if (numList[mid] < temp) {
						min = mid + 1;
					} else {
						max = mid;
					}
				}
				numList[min] = temp;
			}
		}
		System.out.println(cur);

	}

}