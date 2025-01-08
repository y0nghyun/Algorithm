import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 입력: 자연수 N
        int k = scanner.nextInt(); // 입력: K번째 약수
        int count = 0; // 약수의 순서를 카운트

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) { // i가 N의 약수인 경우
                count++;
                if (count == k) { // K번째 약수를 찾았을 때
                    System.out.println(i);
                    return;
                }
            }
        }

        // 약수가 K번째까지 없는 경우
        System.out.println(0);
    }
}