import java.util.*;

class Solution {
    public int maxArea(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[] heights = new int[m];
        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            // Calculate consecutive 1s height
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }

            // Copy and sort heights
            int[] sortedHeights = heights.clone();
            Arrays.sort(sortedHeights);

            // Calculate maximum area
            for (int j = 0; j < m; j++) {
                int height = sortedHeights[j];
                int width = m - j;

                maxArea = Math.max(maxArea, height * width);
            }
        }

        return maxArea;
    }
}