import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int m = Integer.parseInt(br.readLine());
		int[] check = new int[m];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			check[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		for (int target : check) {
			int firstOccurrence = findFirstOccurrence(arr, target);
			int lastOccurrence = findLastOccurrence(arr, target);

			if (firstOccurrence == -1) {
				sb.append(0).append(" ");
			} else {
				sb.append(lastOccurrence - firstOccurrence + 1).append(" ");
			}
		}
		System.out.println(sb);
	}

	private static int findFirstOccurrence(int[] arr, int target) {
		int low = 0;
		int high = arr.length;

		while (low < high) {
			int mid = (low + high) / 2;
			if (arr[mid] < target) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}

		if (low < arr.length && arr[low] == target) {
			return low;
		} else {
			return -1;
		}
	}

	private static int findLastOccurrence(int[] arr, int target) {
		int low = 0;
		int high = arr.length;

		while (low < high) {
			int mid = (low + high) / 2;
			if (arr[mid] <= target) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}

		if (low > 0 && arr[low - 1] == target) {
			return low - 1;
		} else {
			return -1;
		}
	}
}