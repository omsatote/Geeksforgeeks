class Solution {
    static long maxProduct(int[] arr, int k) {
        Long[] maxDP = new Long[k + 1];
        Long[] minDP = new Long[k + 1];

        maxDP[0] = 1L;
        minDP[0] = 1L;

        for (int x : arr) {
            for (int j = k; j >= 1; j--) {
                if (maxDP[j - 1] == null)
                    continue;

                long p1 = maxDP[j - 1] * x;
                long p2 = minDP[j - 1] * x;

                long best = Math.max(p1, p2);
                long worst = Math.min(p1, p2);

                if (maxDP[j] == null) {
                    maxDP[j] = best;
                    minDP[j] = worst;
                } else {
                    maxDP[j] = Math.max(maxDP[j], best);
                    minDP[j] = Math.min(minDP[j], worst);
                }
            }
        }

        return maxDP[k];
    }
}