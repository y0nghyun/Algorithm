import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
    
        int len = sticker.length;
        int[][] dp = new int[len][2];

        dp[0][0] = 0;
        dp[0][1] = sticker[0];
        
        if(len == 1)
            return dp[0][1];
        
        dp[1][1] = 0;
        dp[1][0] = sticker[1];
        
        if(len == 2)
            return Math.max(dp[0][1],dp[1][0]);
        
        dp[2][0] = sticker[2];
        dp[2][1] = sticker[2] + dp[0][1];
        
        if(len == 3)
            return Math.max(dp[1][0],dp[2][1]);
        
        dp[3][0] = dp[1][0] + sticker[3];
        dp[3][1] = dp[0][1] + sticker[3];
        
        for(int i=4; i<sticker.length; i++){
            dp[i][0] = Math.max(dp[i-2][0] + sticker[i], dp[i-3][0] + sticker[i]);
            dp[i][1] = Math.max(dp[i-2][1] + sticker[i], dp[i-3][1] + sticker[i]);
        }
        for(int i=1;i<4;i++){
            if(answer < dp[len-i][0])
                answer = dp[len-i][0];
            if(answer < dp[len-i][1] && i != 1)
                answer = dp[len-i][1];
        }
        
        return answer;
    }
}