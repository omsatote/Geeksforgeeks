class Solution {

    public long minCost(int n, int i, int d, int c) {
        long[] dp = new long[n + 2];

        dp[0] = 0;
        dp[1] = i;

        for (int x = 2; x <= n; x++) {
            dp[x] = dp[x - 1] + i;

            if (x % 2 == 0) {
                dp[x] = Math.min(dp[x], dp[x / 2] + c);
            } else {
                dp[x] = Math.min(dp[x], dp[(x + 1) / 2] + c + d);
            }
        }

        return dp[n];
    }
}