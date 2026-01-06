class Solution {
    public long solution(int n) {
        long answer = 0;
        
        long[] dp = new long[2001];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 5;
        if(n < 5)
            return dp[n];
        for(int i=5; i<n+1; i++){
            dp[i] = (dp[i-2] + dp[i-1]) % 1234567;
        }
        
        return dp[n];
    }
}