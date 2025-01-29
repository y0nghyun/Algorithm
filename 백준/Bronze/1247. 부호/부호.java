import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        for (int t = 0; t < 3; t++) {  // 3번 테스트
            int n = sc.nextInt();  
            BigInteger sum = BigInteger.ZERO;  // 합을 저장할 BigInteger
            
            for (int i = 0; i < n; i++) {
                BigInteger num = sc.nextBigInteger();  // 큰 수 입력 받기
                sum = sum.add(num);  // 누적합
            }
            
            // 결과 출력
            if (sum.compareTo(BigInteger.ZERO) > 0) {
                System.out.println("+");
            } else if (sum.compareTo(BigInteger.ZERO) < 0) {
                System.out.println("-");
            } else {
                System.out.println("0");
            }
        }
        
        sc.close();
    }
}