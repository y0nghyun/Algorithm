import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(br.readLine()); // StringBuilder로 변경

		int cursorIdx = sb.length(); // 초기 커서 위치는 문자열의 끝
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char op = st.nextToken().charAt(0);
			char ch = 0;
			if (op == 'P')
				ch = st.nextToken().charAt(0);

			switch (op) {
			case 'L':
				if (cursorIdx > 0) {
					cursorIdx--;
				}
				break;
			case 'D':
				if (cursorIdx < sb.length()) {
					cursorIdx++;
				}
				break;
			case 'B':
				if (cursorIdx > 0) {
					sb.deleteCharAt(cursorIdx - 1); // 뒤로 한 칸 이동 후 삭제
					cursorIdx--;
				}
				break;
			case 'P':
				sb.insert(cursorIdx, ch); // 커서 위치에 문자 삽입
				cursorIdx++;
				break;
			}
		}
		System.out.println(sb);
	}
}