import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 테스트 케이스 수
        sc.nextLine(); // 개행 문자 소비

        for (int i = 0; i < n; i++) {
            String quiz = sc.nextLine(); // OX 퀴즈 결과
            int score = 0; // 총점
            int consecutive = 0; // 연속 점수

            for (char c : quiz.toCharArray()) {
                if (c == 'O') {
                    consecutive++;
                    score += consecutive;
                } else {
                    consecutive = 0;
                }
            }

            System.out.println(score);
        }

        sc.close();
    }
}