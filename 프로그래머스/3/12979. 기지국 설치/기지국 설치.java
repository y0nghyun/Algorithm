import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int cover = 2*w + 1;
        
        int prev = 1;
        
        for(int s : stations){
            int left = Math.max(1, s - w);
            if(prev < left){
                int len = left - prev;
                answer += len / cover + (len%cover != 0?1:0);
            }
            prev = Math.min(n+1, s+w+1);
        }
        
        if(prev<=n){
            int len = n - prev + 1;
            answer += len / cover + (len%cover != 0?1:0);
        }
        
        return answer;
    }
}