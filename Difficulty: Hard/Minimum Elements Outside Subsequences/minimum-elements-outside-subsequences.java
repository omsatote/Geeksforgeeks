import java.util.*;

class Solution {
    public int minCount(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[102][102];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        dp[0][101] = 0;

        for (int x : arr) {
            int[][] next = new int[102][102];

            for (int[] row : next)
                Arrays.fill(row, -1);

            for (int inc = 0; inc < 102; inc++) {
                for (int dec = 0; dec < 102; dec++) {
                    if (dp[inc][dec] == -1)
                        continue;

                    next[inc][dec] = Math.max(next[inc][dec], dp[inc][dec]);

                    if (inc == 0 || x > inc) {
                        next[x][dec] = Math.max(
                            next[x][dec],
                            dp[inc][dec] + 1
                        );
                    }

                    if (dec == 101 || x < dec) {
                        next[inc][x] = Math.max(
                            next[inc][x],
                            dp[inc][dec] + 1
                        );
                    }
                }
            }

            dp = next;
        }

        int maxUsed = 0;

        for (int i = 0; i < 102; i++) {
            for (int j = 0; j < 102; j++) {
                maxUsed = Math.max(maxUsed, dp[i][j]);
            }
        }

        return n - maxUsed;
    }
}