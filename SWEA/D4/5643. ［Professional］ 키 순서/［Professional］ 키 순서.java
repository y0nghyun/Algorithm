import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	static class Student {
		ArrayList<Integer> prev;
		ArrayList<Integer> next;

		public Student(ArrayList<Integer> prev, ArrayList<Integer> next) {
			this.prev = prev;
			this.next = next;
		}

	}

	static int N;
	static int M;

	static Student[] list;
	static boolean[] visited;

	private static boolean check(int idx) {
		visited = new boolean[N];
		findNext(idx);
		findPrev(idx);
		for (int i = 0; i < N; i++) {
			if (!visited[i])
				return false;
		}
		return true;
	}

	private static void findNext(int num) {
		visited[num] = true;
		for (int i = 0; i < list[num].next.size(); i++) {
			if (visited[list[num].next.get(i)])
				continue;
			findNext(list[num].next.get(i));
		}
	}

	private static void findPrev(int num) {
		visited[num] = true;
		for (int i = 0; i < list[num].prev.size(); i++) {
			if (visited[list[num].prev.get(i)])
				continue;
			findPrev(list[num].prev.get(i));
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tNum = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= tNum; TC++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());

			list = new Student[N];
			for (int i = 0; i < N; i++) {
				ArrayList<Integer> prev = new ArrayList<>();
				ArrayList<Integer> next = new ArrayList<>();
				list[i] = new Student(prev, next);
			}

			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int to = Integer.parseInt(st.nextToken()) - 1;
				int from = Integer.parseInt(st.nextToken()) - 1;
				list[to].next.add(from);
				list[from].prev.add(to);
			}

			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (check(i)) {
					cnt++;
				}
			}
			System.out.println("#" + TC + " " + cnt);
		}
	}

}