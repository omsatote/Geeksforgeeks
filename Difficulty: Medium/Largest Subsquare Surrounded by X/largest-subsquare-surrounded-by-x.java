class Solution {

    public int largestSubsquare(char[][] mat) {

        int n = mat.length;

        int[][] right = new int[n][n];
        int[][] down = new int[n][n];

        // Precompute consecutive X's to the right and downward
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                if (mat[i][j] == 'X') {

                    right[i][j] = 1;
                    down[i][j] = 1;

                    if (j + 1 < n) {
                        right[i][j] += right[i][j + 1];
                    }

                    if (i + 1 < n) {
                        down[i][j] += down[i + 1][j];
                    }
                }
            }
        }

        int ans = 0;

        // Check every cell as the top-left corner
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int maxSize = Math.min(right[i][j], down[i][j]);

                for (int size = maxSize; size > ans; size--) {

                    int bottom = i + size - 1;
                    int lastCol = j + size - 1;

                    if (bottom < n && lastCol < n) {

                        // Bottom boundary
                        boolean bottomOK = right[bottom][j] >= size;

                        // Right boundary
                        boolean rightOK = down[i][lastCol] >= size;

                        if (bottomOK && rightOK) {
                            ans = size;
                            break;
                        }
                    }
                }
            }
        }

        return ans;
    }
}