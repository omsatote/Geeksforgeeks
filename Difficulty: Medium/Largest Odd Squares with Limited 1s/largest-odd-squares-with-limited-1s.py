class Solution:
    def largestSquare(self, mat, queries, k):
        n = len(mat)
        m = len(mat[0])

        # Prefix sum of ones
        pref = [[0] * (m + 1) for _ in range(n + 1)]
        for i in range(n):
            row = 0
            for j in range(m):
                row += mat[i][j]
                pref[i + 1][j + 1] = pref[i][j + 1] + row

        def ones(r1, c1, r2, c2):
            return (
                pref[r2 + 1][c2 + 1]
                - pref[r1][c2 + 1]
                - pref[r2 + 1][c1]
                + pref[r1][c1]
            )

        ans = []

        for x, y in queries:
            max_rad = min(x, y, n - 1 - x, m - 1 - y)

            lo, hi = 0, max_rad
            best = -1

            while lo <= hi:
                mid = (lo + hi) // 2
                r1, c1 = x - mid, y - mid
                r2, c2 = x + mid, y + mid

                if ones(r1, c1, r2, c2) <= k:
                    best = 2 * mid + 1
                    lo = mid + 1
                else:
                    hi = mid - 1

            ans.append(best)

        return ans