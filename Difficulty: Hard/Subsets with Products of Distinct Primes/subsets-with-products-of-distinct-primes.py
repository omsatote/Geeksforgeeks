class Solution:
    def countSubsets(self, arr):
        MOD = 10**9 + 7

        primes = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29]

        freq = [0] * 31
        for x in arr:
            freq[x] += 1

        masks = {}

        for x in range(2, 31):
            t = x
            mask = 0
            ok = True

            for i, p in enumerate(primes):
                cnt = 0
                while t % p == 0:
                    cnt += 1
                    t //= p
                if cnt > 1:
                    ok = False
                    break
                if cnt == 1:
                    mask |= (1 << i)

            if ok:
                masks[x] = mask

        dp = [0] * (1 << 10)
        dp[0] = 1

        for x in range(2, 31):
            if freq[x] == 0 or x not in masks:
                continue

            mask = masks[x]

            for state in range((1 << 10) - 1, -1, -1):
                if (state & mask) == 0:
                    dp[state | mask] = (dp[state | mask] + dp[state] * freq[x]) % MOD

        ans = (sum(dp) - 1) % MOD
        ans = ans * pow(2, freq[1], MOD) % MOD

        return ans