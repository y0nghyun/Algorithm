import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력받기
        int L = sc.nextInt(); // 방학 일수
        int A = sc.nextInt(); // 국어 총 페이지
        int B = sc.nextInt(); // 수학 총 페이지
        int C = sc.nextInt(); // 하루 최대 국어 공부량
        int D = sc.nextInt(); // 하루 최대 수학 공부량

        // 필요한 일수 계산 (올림 처리)
        int koreanDays = (A + C - 1) / C; // (A + C - 1) / C는 Math.ceil(A / C)와 같음
        int mathDays = (B + D - 1) / D;

        // 방학 중 남은 날 계산
        int remainingDays = L - Math.max(koreanDays, mathDays);

        System.out.println(remainingDays);
    }
}
