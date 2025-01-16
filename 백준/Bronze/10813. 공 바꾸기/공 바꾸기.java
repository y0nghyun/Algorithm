import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 바구니 개수
        int M = Integer.parseInt(st.nextToken()); // 교환 횟수

        // 바구니 초기화
        int[] baskets = new int[N];
        for (int i = 0; i < N; i++) {
            baskets[i] = i + 1; // 1번부터 N번까지 공 번호 초기화
        }

        // 공 바꾸기 작업 수행
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1; // 0-based index
            int b = Integer.parseInt(st.nextToken()) - 1; // 0-based index

            // 두 바구니의 공 교환
            int temp = baskets[a];
            baskets[a] = baskets[b];
            baskets[b] = temp;
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(baskets[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}