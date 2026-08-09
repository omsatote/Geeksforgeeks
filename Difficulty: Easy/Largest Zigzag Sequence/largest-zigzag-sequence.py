class Solution:
    def zigzagSequence(self, mat):
        n = len(mat)

        dp = mat[0][:]

        for i in range(1, n):
            max1 = -1
            max2 = -1
            idx1 = -1

            # Find maximum and second maximum of previous row
            for j in range(n):
                if dp[j] > max1:
                    max2 = max1
                    max1 = dp[j]
                    idx1 = j
                elif dp[j] > max2:
                    max2 = dp[j]

            new_dp = [0] * n

            for j in range(n):
                if j == idx1:
                    new_dp[j] = mat[i][j] + max2
                else:
                    new_dp[j] = mat[i][j] + max1

            dp = new_dp

        return max(dp)