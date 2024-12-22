import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<Integer> remainders = new HashSet<>();

        // 10개의 숫자를 입력받아 42로 나눈 나머지를 HashSet에 저장
        for (int i = 0; i < 10; i++) {
            int number = scanner.nextInt();
            remainders.add(number % 42);
        }

        // HashSet의 크기가 서로 다른 나머지의 개수
        System.out.println(remainders.size());
    }
}