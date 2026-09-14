import java.util.*;

class Solution {
    static class P {
        int r, c, d;

        P(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    public int shortestPath(int[][] mat) {
        int n = mat.length, m = mat[0].length;

        boolean[][] bad = new boolean[n][m];
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    bad[i][j] = true;

                    for (int k = 0; k < 4; k++) {
                        int r = i + dr[k];
                        int c = j + dc[k];

                        if (r >= 0 && r < n && c >= 0 && c < m)
                            bad[r][c] = true;
                    }
                }
            }
        }

        Queue<P> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            if (!bad[i][0]) {
                q.add(new P(i, 0, 1));
                vis[i][0] = true;
            }
        }

        while (!q.isEmpty()) {
            P p = q.poll();

            if (p.c == m - 1)
                return p.d;

            for (int k = 0; k < 4; k++) {
                int r = p.r + dr[k];
                int c = p.c + dc[k];

                if (r >= 0 && r < n && c >= 0 && c < m &&
                    !bad[r][c] && !vis[r][c]) {

                    vis[r][c] = true;
                    q.add(new P(r, c, p.d + 1));
                }
            }
        }

        return -1;
    }
}