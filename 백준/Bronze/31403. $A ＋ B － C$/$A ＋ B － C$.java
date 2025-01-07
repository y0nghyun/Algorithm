import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 세 정수 A, B, C를 입력받습니다.
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        // 1. 숫자로서의 연산: A + B - C
        int numericResult = A + B - C;
        System.out.println(numericResult);

        // 2. 문자열로서의 연산: A와 B를 문자열로 이어붙인 후 정수로 변환하여 C를 뺌
        String concatenatedString = String.valueOf(A) + String.valueOf(B);
        int concatenatedNumber = Integer.parseInt(concatenatedString);
        int stringResult = concatenatedNumber - C;
        System.out.println(stringResult);
    }
}