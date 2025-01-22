import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()); // 옵션 개수 입력

        boolean[] usedKeys = new boolean[26]; // 단축키 사용 여부 저장 (a~z)

        for (int i = 0; i < N; i++) {
            String option = br.readLine(); // 옵션 문자열 입력
            String[] words = option.split(" "); // 옵션을 단어별로 분리
            boolean shortcutAssigned = false;

            // 1단계: 단어의 첫 글자 우선 확인
            for (int j = 0; j < words.length; j++) {
                char firstChar = words[j].charAt(0);
                char lowerChar = Character.toLowerCase(firstChar);

                if (!usedKeys[lowerChar - 'a']) { // 단축키로 사용되지 않았다면
                    usedKeys[lowerChar - 'a'] = true; // 단축키로 등록
                    words[j] = "[" + words[j].charAt(0) + "]" + words[j].substring(1); // 대괄호로 감싸기
                    sb.append(String.join(" ", words)).append("\n");
                    shortcutAssigned = true;
                    break;
                }
            }

            // 2단계: 첫 글자에 단축키를 지정하지 못한 경우, 옵션 전체에서 사용되지 않은 문자 찾기
            if (!shortcutAssigned) {
                for (int j = 0; j < option.length(); j++) {
                    char c = option.charAt(j);
                    if (c == ' ') continue; // 공백은 건너뜀
                    char lowerChar = Character.toLowerCase(c);

                    if (!usedKeys[lowerChar - 'a']) { // 단축키로 사용되지 않았다면
                        usedKeys[lowerChar - 'a'] = true; // 단축키로 등록
                        sb.append(option.substring(0, j)).append("[").append(option.charAt(j)).append("]").append(option.substring(j + 1)).append("\n");
                        shortcutAssigned = true;
                        break;
                    }
                }
            }

            // 3단계: 단축키를 지정하지 못한 경우, 원본 옵션 그대로 출력
            if (!shortcutAssigned) {
                sb.append(option).append("\n");
            }
        }

        System.out.print(sb.toString()); // 결과 출력
    }
}