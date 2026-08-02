class Solution {
    public int count(int n, int m) {
        int[][] dp = new int[n + 1][m + 1];

        // Base case
        for (int j = 1; j <= m; j++) {
            dp[1][j] = 1;
        }

        // DP
        for (int len = 2; len <= n; len++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= m; k++) {
                    if (j % k == 0 || k % j == 0) {
                        dp[len][j] += dp[len - 1][k];
                    }
                }
            }
        }

        int ans = 0;
        for (int j = 1; j <= m; j++) {
            ans += dp[n][j];
        }

        return ans;
    }
}