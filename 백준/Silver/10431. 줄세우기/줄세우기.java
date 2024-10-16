import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        for (int TC = 1; TC <= P; TC++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken()); // 테스트 케이스 번호
            int cnt = 0; // 이동 횟수를 저장할 변수
            int[] students = new int[20];
            for (int i = 0; i < 20; i++) {
                students[i] = Integer.parseInt(st.nextToken());
            }
            // 삽입 정렬을 사용하여 이동 횟수 계산
            for (int i = 1; i < 20; i++) {
                int key = students[i];
                int j = i - 1;
                while (j >= 0 && students[j] > key) {
                    students[j + 1] = students[j];
                    cnt++;
                    j--;
                }
                students[j + 1] = key;
            }
            System.out.println(T + " " + cnt);
        }
    }
}