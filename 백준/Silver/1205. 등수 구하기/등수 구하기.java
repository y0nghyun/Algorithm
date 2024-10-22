import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());  // 기존 랭킹에 등록된 점수 개수
        int score = Integer.parseInt(st.nextToken());  // 새로 등록할 점수
        int P = Integer.parseInt(st.nextToken());  // 랭킹에 등록 가능한 최대 인원 수

        // 점수가 없으면 바로 1등 출력
        if (N == 0) {
            System.out.println(1);
            return;
        }

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int rank = -1;  // 새 점수가 들어갈 순위
        for (int i = 0; i < N; i++) {
            if (score >= arr[i]) {  // 새 점수가 더 높거나 같은 경우
                rank = i + 1;  // 해당 위치에 삽입 (0-index 이므로 +1)
                break;
            }
        }

        // 순위가 결정되지 않으면 마지막에 추가될 것 (N+1등)
        if (rank == -1) {
            rank = N + 1;
        }

        // 랭킹에 자리가 없을 경우 (P명이 꽉 찬 상태에서 새 점수가 추가될 수 있는지 확인)
        if (N == P && rank > P) {
            System.out.println(-1);
            return;
        }

        // 최하위 점수와 동점일 때 새 점수가 추가될 수 없으면 -1 출력
        if (N == P && arr[N - 1] == score) {
            System.out.println(-1);
            return;
        }

        System.out.println(rank);
    }
}