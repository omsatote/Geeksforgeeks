class Solution {
    public long formPyramid(int[] arr) {
        int n = arr.length;
        long total = 0;

        for (int x : arr) {
            total += x;
        }

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;

        for (int i = 1; i < n; i++) {
            left[i] = Math.min(arr[i], left[i - 1] + 1);
        }

        right[n - 1] = 1;

        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.min(arr[i], right[i + 1] + 1);
        }

        long maxPyramid = 1;

        for (int i = 0; i < n; i++) {
            int peak = Math.min(left[i], right[i]);
            maxPyramid = Math.max(maxPyramid, (long) peak * peak);
        }

        return total - maxPyramid;
    }
}