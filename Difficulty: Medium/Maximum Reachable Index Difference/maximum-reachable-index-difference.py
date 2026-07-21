class Solution:
    def maxIndexDifference(self, s):
        n = len(s)

        best = [-1] * 26
        dp = [0] * n
        ans = -1

        for i in range(n - 1, -1, -1):
            c = ord(s[i]) - ord('a')

            if c == 25:  # 'z'
                dp[i] = i
            elif best[c + 1] != -1:
                dp[i] = best[c + 1]
            else:
                dp[i] = i

            best[c] = max(best[c], dp[i])

            if s[i] == 'a':
                ans = max(ans, dp[i] - i)

        return ans