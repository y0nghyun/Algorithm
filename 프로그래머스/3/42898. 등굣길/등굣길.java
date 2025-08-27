class Solution {

    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];
        boolean[][] blocked = new boolean[n][m];

        for (int[] p : puddles) {
            int y = p[1] - 1;
            int x = p[0] - 1;
            blocked[y][x] = true;
        }

        if (blocked[0][0]) return 0;

        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) continue;
                if (blocked[i][j]) {
                    dp[i][j] = 0;
                    continue;
                }
                int up = (i > 0) ? dp[i - 1][j] : 0;
                int left = (j > 0) ? dp[i][j - 1] : 0;
                dp[i][j] = (int) ((up + left) % 1000_000007);
            }
        }

        return dp[n - 1][m - 1];
    }
}
