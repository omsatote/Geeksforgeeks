import java.util.*;

class Solution {
    public int longestSubseq(int[] arr) {
        HashMap<Integer, Integer> dp = new HashMap<>();

        int ans = 0;

        for (int x : arr) {
            int len = Math.max(
                dp.getOrDefault(x - 1, 0),
                dp.getOrDefault(x + 1, 0)
            ) + 1;

            dp.put(x, Math.max(dp.getOrDefault(x, 0), len));

            ans = Math.max(ans, dp.get(x));
        }

        return ans;
    }
}