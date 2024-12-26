import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int original = n; // 시작 숫자 저장
        int count = 0; // 사이클 길이
        
        do {
            int tens = n / 10; // 10의 자리
            int units = n % 10; // 1의 자리
            int sum = tens + units; // 각 자리수의 합
            n = (units * 10) + (sum % 10); // 새로운 숫자 생성
            count++; // 사이클 증가
        } while (n != original); // 처음 수로 돌아올 때까지 반복
        
        System.out.println(count);
    }
}