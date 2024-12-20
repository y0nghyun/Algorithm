import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M, L, K;
    static ArrayList<Point> stars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        stars = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            stars.add(new Point(x, y));
        }

        int ans = K;

        for (Point p1 : stars) {
            for (Point p2 : stars) {
                int startX = p1.x;
                int startY = p2.y;

                int endX = startX + L;
                int endY = startY + L;

                int count = 0;

                for (Point star : stars) {
                    if (star.x >= startX && star.x <= endX &&
                        star.y >= startY && star.y <= endY) {
                        count++;
                    }
                }

                ans = Math.min(ans, K - count);
            }
        }

        System.out.println(ans);
    }
}