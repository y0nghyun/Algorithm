import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); // 입력 개수
        int[] arr = new int[n];
        
        // 배열에 숫자 입력
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        // 배열 정렬
        Arrays.sort(arr);
        
        // 정렬된 결과 출력
        for (int num : arr) {
            System.out.println(num);
        }
        
        sc.close();
    }
}