class Solution {
    
    
    public int[] solution(int n, int s) {
        int[] answer;
        if(s < n){
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        answer = new int[n];
        double avg = s / n;
        int num = (int) avg;
        
        int cnt = 0;
        for(int i=0; i<=n; i++){
            int target = num*i + (num+1)*(n-i);
            if(s == target){
                cnt = i;
                break;
            }
        }
        for(int i=0; i<cnt; i++){
            answer[i] = num;
        }
        for(int i=cnt; i<n; i++){
            answer[i] = num+1;
        }
                
        return answer;
    }
}