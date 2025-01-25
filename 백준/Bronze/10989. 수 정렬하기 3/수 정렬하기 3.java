import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 입력받을 수의 개수
        int[] count = new int[10001]; // 1부터 10,000까지의 수를 저장할 배열

        // 입력받아 카운트
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            count[number]++;
        }

        // 결과 출력
        for (int i = 1; i < count.length; i++) {
            while (count[i] > 0) {
                sb.append(i).append("\n");
                count[i]--;
            }
        }

        System.out.print(sb);
    }
}