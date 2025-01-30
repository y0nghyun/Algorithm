import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int D = sc.nextInt();
        sc.close();
        
        int A = (S + D) / 2;
        int B = (S - D) / 2;
        
        if ((S + D) % 2 != 0 || (S - D) % 2 != 0 || A < 0 || B < 0) {
            System.out.println(-1);
        } else {
            System.out.println(Math.max(A, B) + " " + Math.min(A, B));
        }
    }
}