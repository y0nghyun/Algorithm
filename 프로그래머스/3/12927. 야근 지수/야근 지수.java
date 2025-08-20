import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i< works.length; i++){
            queue.offer(works[i]);
        }
        
        for(int i=0; i<n; i++){
            int temp = queue.poll();
            if(temp == 0)
                break;
            temp -= 1;
            queue.offer(temp);
        }
        
        while(!queue.isEmpty()){
            int temp = queue.poll();
            answer += temp*temp;
        }        
        return answer;
    }
}