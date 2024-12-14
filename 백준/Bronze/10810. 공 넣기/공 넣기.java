import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력받기
        int N = scanner.nextInt(); // 바구니 수
        int M = scanner.nextInt(); // 작업 수

        int[] baskets = new int[N]; // 바구니 배열 (0으로 초기화)

        // 작업 처리
        for (int t = 0; t < M; t++) {
            int i = scanner.nextInt(); // 시작 바구니 번호
            int j = scanner.nextInt(); // 끝 바구니 번호
            int k = scanner.nextInt(); // 채울 값

            // 범위 [i, j]에 값 k를 넣음
            for (int idx = i - 1; idx < j; idx++) {
                baskets[idx] = k;
            }
        }

        // 결과 출력
        for (int basket : baskets) {
            System.out.print(basket + " ");
        }
    }
}