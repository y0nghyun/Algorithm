import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static class Top {
        int num;
        int height;

        public Top(int num, int height) {
            this.num = num;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<Top> stack = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            int height = Integer.parseInt(st.nextToken());
            if (stack.isEmpty()) {
                sb.append("0 ");
                stack.push(new Top(i, height));
            } else {
                while (true) {
                    if (stack.isEmpty()) {
                        sb.append("0 ");
                        stack.push(new Top(i, height));
                        break;
                    }
                    Top top = stack.peek();
                    if (top.height > height) {
                        sb.append(top.num + " ");
                        stack.push(new Top(i, height));
                        break;
                    } else {
                        stack.pop();
                    }
                }

            }

        }
        System.out.println(sb.toString());
    }
}