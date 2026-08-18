class Solution {
    public String compress(String s) {
        int n = s.length(), INF = 1000000;
        int[] z = new int[n];

        for (int i = 1, l = 0, r = 0; i < n; i++) {
            if (i < r) z[i] = Math.min(r - i, z[i - l]);

            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i]))
                z[i]++;

            if (i + z[i] > r) {
                l = i;
                r = i + z[i];
            }
        }

        int[] dp = new int[n + 1];
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1 + dp[i + 1];

            if (i > 0 && 2 * i <= n && z[i] >= i)
                dp[i] = Math.min(dp[i], 1 + dp[2 * i]);
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n;) {
            if (i > 0 && 2 * i <= n && z[i] >= i
                    && dp[i] == 1 + dp[2 * i]) {
                ans.append('*');
                i *= 2;
            } else {
                ans.append(s.charAt(i++));
            }
        }

        return ans.toString();
    }
}