class Solution:
    def findWays(self, grid):
        MOD = 10**9 + 7
        n = len(grid)

        ways = [[0] * n for _ in range(n)]
        best = [[-1] * n for _ in range(n)]

        ways[0][0] = 1
        best[0][0] = grid[0][0]

        for i in range(n):
            for j in range(n):
                if ways[i][j] == 0:
                    continue

                # Move Right
                if grid[i][j] in (1, 3) and j + 1 < n:
                    ways[i][j + 1] = (ways[i][j + 1] + ways[i][j]) % MOD
                    best[i][j + 1] = max(best[i][j + 1],
                                         best[i][j] + grid[i][j + 1])

                # Move Down
                if grid[i][j] in (2, 3) and i + 1 < n:
                    ways[i + 1][j] = (ways[i + 1][j] + ways[i][j]) % MOD
                    best[i + 1][j] = max(best[i + 1][j],
                                         best[i][j] + grid[i + 1][j])

        if ways[n - 1][n - 1] == 0:
            return [0, 0]

        return [ways[n - 1][n - 1], best[n - 1][n - 1]]