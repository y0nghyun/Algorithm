import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(B);
        Arrays.sort(A);
        boolean[] isUsed = new boolean[A.length];
        
        int idx = B.length - 1;
        for(int i=B.length-1; i>=0; i--){
            for(int j=idx; j>=0; j--){
                if(B[i] > A[j] && !isUsed[j]){
                    answer++;
                    isUsed[j] = true;
                    idx = j-1;
                    break;
                }
            }
        }
        return answer;
    }
}