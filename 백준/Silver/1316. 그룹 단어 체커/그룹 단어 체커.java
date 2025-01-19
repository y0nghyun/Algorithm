import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ans = 0;

        for (int i = 0; i < N; i++) {
            boolean[] alp = new boolean[26];
            boolean flag = true;
            String s = sc.next();

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);

                if (!alp[c - 'a']) {
                    alp[c - 'a'] = true;
                } else if (j > 0 && s.charAt(j - 1) == c) {
                    continue;
                } else {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}