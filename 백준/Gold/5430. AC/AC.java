import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Main {

	static ArrayList<Character> Op;
	static int N;
	static Deque<Integer> q;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tNum = Integer.parseInt(br.readLine());
		for (int TC = 0; TC < tNum; TC++) {
			StringBuilder sb = new StringBuilder();
			Op = new ArrayList<>();

			String S = br.readLine();
			for (int i = 0; i < S.length(); i++) {
				Op.add(S.charAt(i));
			}
			N = Integer.parseInt(br.readLine());
			q = new ArrayDeque<>();
			S = br.readLine();
			int idx = 0;
			while (idx != S.length()) {
				if (S.charAt(idx) >= '0' && S.charAt(idx) <= '9') {
					String temp = " ";
					while (S.charAt(idx) >= '0' && S.charAt(idx) <= '9') {
						temp += S.charAt(idx);
						idx++;
					}
					temp = temp.substring(1);
					q.add(Integer.parseInt(temp));
				} else {
					idx++;
				}
			}
			int dir = 0; // 0면 앞 1이면 뒤
			int flag = 0;
			for (int i = 0; i < Op.size(); i++) {
				if (Op.get(i) == 'R' && dir == 0) {
					dir = 1;
				} else if (Op.get(i) == 'R' && dir == 1) {
					dir = 0;
				} else if (Op.get(i) == 'D' && dir == 0) {
					if (q.size() == 0) {
						flag = 1;
						break;
					}
					q.pollFirst();
				} else {
					if (q.size() == 0) {
						flag = 1;
						break;
					}
					q.pollLast();
				}

			}
			if (flag == 0) {
				sb.append('[');
				while (!q.isEmpty()) {
					int num;
					if (dir == 0) {
						num = q.pollFirst();
						if (!q.isEmpty()) {
							sb.append(num).append(',');
						} else {
							sb.append(num);
						}
					} else {
						num = q.pollLast();
						if (!q.isEmpty()) {
							sb.append(num).append(',');
						} else {
							sb.append(num);
						}
					}
				}
				sb.append(']');
				System.out.println(sb);
			} else {
				System.out.println("error");
			}
		}
	}

}