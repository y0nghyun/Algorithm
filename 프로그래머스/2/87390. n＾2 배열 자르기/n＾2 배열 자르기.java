import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int len = (int)(right-left+1);
        int[] answer = new int[len];
        long idx = left;
        for(int i=0; i<len; i++){
            answer[i] = Math.max((int)(idx/n),(int)(idx%n))+1;
            idx++;
        }
        return answer;
    }
}