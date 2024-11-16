import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력으로 매우 큰 두 수를 받습니다.
        BigInteger n = sc.nextBigInteger();
        BigInteger m = sc.nextBigInteger();

        // n을 m으로 나눈 몫을 출력
        System.out.println(n.divide(m));
        // n을 m으로 나눈 나머지를 출력
        System.out.println(n.remainder(m));
        
        sc.close();
    }
}