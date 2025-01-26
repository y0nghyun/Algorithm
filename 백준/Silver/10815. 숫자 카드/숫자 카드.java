import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 효율적으로 받기 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 상근이가 가진 카드의 개수
        int n = Integer.parseInt(br.readLine());
        // 카드 숫자를 배열로 입력받아 정렬
        int[] cards = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        Arrays.sort(cards); // 이진 탐색을 위해 정렬

        // 찾으려는 숫자의 개수
        int m = Integer.parseInt(br.readLine());
        // 찾으려는 숫자들
        int[] targets = Arrays.stream(br.readLine().split(" "))
                              .mapToInt(Integer::parseInt)
                              .toArray();
        
        // 각 숫자가 있는지 확인
        for (int target : targets) {
            if (binarySearch(cards, target)) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }
        
        // 결과 출력
        System.out.println(sb.toString().trim());
    }

    // 이진 탐색 메서드
    private static boolean binarySearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == key) {
                return true;
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}