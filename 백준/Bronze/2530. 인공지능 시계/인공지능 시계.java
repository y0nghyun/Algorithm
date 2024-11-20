import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 시, 분, 초 입력받기
        int h = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();
        
        // 더할 초 입력받기
        int add_s = sc.nextInt();
        
        // 초 더하기
        s += add_s;

        // 60초를 넘는 경우, 분에 더하고 초는 0~59로 유지
        if (s >= 60) {
            m += s / 60;
            s = s % 60;
        }

        // 60분을 넘는 경우, 시간에 더하고 분은 0~59로 유지
        if (m >= 60) {
            h += m / 60;
            m = m % 60;
        }

        // 24시간을 넘는 경우, 24시 기준으로 처리
        if (h >= 24) {
            h = h % 24;
        }

        // 결과 출력
        System.out.println(h + " " + m + " " + s);
    }
}