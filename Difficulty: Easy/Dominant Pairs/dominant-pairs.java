
import java.util.*;

class Solution {
    public int dominantPairs(int[] arr) {
        int n = arr.length;
        int half = n / 2;

        int[] second = Arrays.copyOfRange(arr, half, n);
        Arrays.sort(second);

        int ans = 0;

        for (int i = 0; i < half; i++) {
            long limit = Math.floorDiv((long) arr[i], 5);
            int low = 0, high = second.length;

            while (low < high) {
                int mid = low + (high - low) / 2;
                if (second[mid] <= limit) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }

            ans += low;
        }

        return ans;
    }
}
