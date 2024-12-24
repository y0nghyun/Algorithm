import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        int[] alphabet = new int[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = -1; // 초기값 -1로 설정
        }

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int index = c - 'a'; // 'a'를 기준으로 인덱스 계산
            if (alphabet[index] == -1) { // 아직 등장하지 않은 경우
                alphabet[index] = i; // 등장한 위치 저장
            }
        }

        for (int i = 0; i < 26; i++) {
            System.out.print(alphabet[i] + " ");
        }
    }
}