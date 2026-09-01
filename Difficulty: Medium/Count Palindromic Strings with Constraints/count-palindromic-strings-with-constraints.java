class Solution {
    static final long MOD = 1000000007L;

    public long palindromicStrings(int n, int k) {
        long ans = 0;
        long perm = 1;

        // Odd length palindromes
        for (int m = 0; m <= Math.min(k, (n - 1) / 2); m++) {
            ans = (ans + perm * (k - m)) % MOD;

            if (m < k) {
                perm = (perm * (k - m)) % MOD;
            }
        }

        // Even length palindromes
        perm = 1;

        for (int m = 1; m <= Math.min(k, n / 2); m++) {
            perm = (perm * (k - m + 1)) % MOD;
            ans = (ans + perm) % MOD;
        }

        return ans;
    }
}