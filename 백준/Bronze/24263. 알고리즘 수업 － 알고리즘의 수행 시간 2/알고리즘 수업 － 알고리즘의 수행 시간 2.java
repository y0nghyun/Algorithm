import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력받은 n
        int n = scanner.nextInt();

        // 알고리즘의 수행 횟수는 n
        System.out.println(n);

        // 알고리즘의 시간 복잡도는 O(n)
        System.out.println(1);

        scanner.close();
    }
}