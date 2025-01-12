import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int T = 0; T < TC; T++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            int maxLen = 0;
            int minLen = W.length();

            ArrayList<Integer>[] alps = new ArrayList[26];
            for (int i = 0; i < 26; i++) {
                alps[i] = new ArrayList<>();
            }

            for (int i = 0; i < W.length(); i++) {
                alps[W.charAt(i) - 'a'].add(i);
            }

            for (int i = 0; i < 26; i++) {
                if (alps[i].size() >= K) {
                    for (int j = 0; j <= alps[i].size() - K; j++) {
                        int length = alps[i].get(j + K - 1) - alps[i].get(j) + 1;
                        minLen = Math.min(minLen, length);
                        maxLen = Math.max(maxLen, length);
                    }
                }
            }

            if (maxLen == 0) {
                sb.append(-1).append("\n");
            } else {
                sb.append(minLen).append(" ").append(maxLen).append("\n");
            }
        }
        System.out.print(sb);
    }
}