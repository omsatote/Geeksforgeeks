import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> searchWord(char[][] mat, String word) {
        int n = mat.length;
        int m = mat[0].length;

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        // 8 directions
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        int len = word.length();

        // Check every cell as a starting position
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {

                // First character must match
                if (mat[r][c] != word.charAt(0)) {
                    continue;
                }

                // Try all 8 directions
                for (int d = 0; d < 8; d++) {
                    boolean found = true;

                    for (int k = 1; k < len; k++) {
                        int nr = r + dr[d] * k;
                        int nc = c + dc[d] * k;

                        // Check boundary
                        if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                            found = false;
                            break;
                        }

                        // Check character
                        if (mat[nr][nc] != word.charAt(k)) {
                            found = false;
                            break;
                        }
                    }

                    if (found) {
                        ArrayList<Integer> position = new ArrayList<>();
                        position.add(r);
                        position.add(c);

                        ans.add(position);

                        // Avoid duplicate starting positions
                        break;
                    }
                }
            }
        }

        return ans;
    }
}