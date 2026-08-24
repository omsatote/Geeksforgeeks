class Solution {
    static final long MOD = 1000000007L;

    public int prefixStrings(int n) {
        long[] fact = new long[2 * n + 1];

        fact[0] = 1;

        // Calculate factorials
        for (int i = 1; i <= 2 * n; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        // C(2n, n)
        long comb = fact[2 * n];

        comb = (comb * power(fact[n], MOD - 2)) % MOD;
        comb = (comb * power(fact[n], MOD - 2)) % MOD;

        // Catalan number
        long ans = (comb * power(n + 1, MOD - 2)) % MOD;

        return (int) ans;
    }

    private long power(long a, long b) {
        long result = 1;

        while (b > 0) {
            if ((b & 1) == 1) {
                result = (result * a) % MOD;
            }

            a = (a * a) % MOD;
            b >>= 1;
        }

        return result;
    }
}