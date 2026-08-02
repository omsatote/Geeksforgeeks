class Solution:
    def count(self, n, m):
        dp = [[0] * (m + 1) for _ in range(n + 1)]

        # Base case
        for x in range(1, m + 1):
            dp[1][x] = 1

        # DP transitions
        for i in range(2, n + 1):
            for x in range(1, m + 1):
                for y in range(1, m + 1):
                    if x % y == 0 or y % x == 0:
                        dp[i][x] += dp[i - 1][y]

        return sum(dp[n][1:])