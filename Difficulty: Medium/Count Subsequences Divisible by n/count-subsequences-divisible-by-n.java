class Solution {
    static final int MOD = 1_000_000_007;

    public int countSubsequences(String s, int n) {
        long[] dp = new long[n];

        for (char ch : s.toCharArray()) {
            int digit = ch - '0';

            // Skip current digit
            long[] newDp = dp.clone();

            // Start a new subsequence with current digit
            int rem = digit % n;
            newDp[rem] = (newDp[rem] + 1) % MOD;

            // Append current digit to existing subsequences
            for (int r = 0; r < n; r++) {
                if (dp[r] != 0) {
                    int newRem = (r * 10 + digit) % n;

                    newDp[newRem] =
                        (newDp[newRem] + dp[r]) % MOD;
                }
            }

            dp = newDp;
        }

        return (int) dp[0];
    }
}