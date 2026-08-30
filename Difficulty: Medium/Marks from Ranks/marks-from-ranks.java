import java.util.*;

class Solution {
    public ArrayList<Integer> getMarks(int[] l, int[] r, int[] rank) {
        int n = l.length;

        long[] prefix = new long[n];
        prefix[0] = r[0] - l[0] + 1L;

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + (r[i] - l[i] + 1L);
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int j = 0; j < rank.length; j++) {
            long k = rank[j];

            int low = 0;
            int high = n - 1;

            while (low < high) {
                int mid = low + (high - low) / 2;

                if (prefix[mid] >= k) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            int index = low;
            long previous = index > 0 ? prefix[index - 1] : 0;

            int mark = (int) (l[index] + k - previous - 1);
            ans.add(mark);
        }

        return ans;
    }
}