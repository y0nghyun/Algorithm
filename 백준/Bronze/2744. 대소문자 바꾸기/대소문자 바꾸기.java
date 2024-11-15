import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String result = changeCase(input);

        System.out.println(result);

        scanner.close(); // Scanner 닫기
    }

    public static String changeCase(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // 대문자는 소문자로, 소문자는 대문자로 변환
            if (Character.isUpperCase(ch)) {
                sb.append(Character.toLowerCase(ch));
            } else if (Character.isLowerCase(ch)) {
                sb.append(Character.toUpperCase(ch));
            } else {
                // 알파벳이 아닌 경우 그대로 추가
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}