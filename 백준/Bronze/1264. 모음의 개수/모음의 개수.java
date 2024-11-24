import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            // 입력받기
            String line = scanner.nextLine();
            
            // 종료 조건
            if (line.equals("#")) {
                break;
            }
            
            // 모음 개수 세기
            int count = 0;
            for (char c : line.toLowerCase().toCharArray()) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    count++;
                }
            }
            
            // 결과 출력
            System.out.println(count);
        }
        
        scanner.close();
    }
}
