import java.util.*;

class Solution {

    static class State {
        int row;
        int col;
        int up;

        State(int row, int col, int up) {
            this.row = row;
            this.col = col;
            this.up = up;
        }
    }

    public int numberOfCells(int r, int c, int u, int d, char[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        if (mat[r][c] == '#') {
            return 0;
        }

        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        Deque<State> dq = new ArrayDeque<>();

        dist[r][c] = 0;
        dq.addFirst(new State(r, c, 0));

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!dq.isEmpty()) {

            State cur = dq.pollFirst();

            int x = cur.row;
            int y = cur.col;
            int up = cur.up;

            if (up != dist[x][y]) {
                continue;
            }

            for (int k = 0; k < 4; k++) {

                int nx = x + dr[k];
                int ny = y + dc[k];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (mat[nx][ny] == '#') {
                    continue;
                }

                int newUp = up;

                if (nx < x) {
                    newUp++;
                }

                int newDown = newUp + (nx - r);

                if (newUp > u || newDown > d) {
                    continue;
                }

                if (newUp < dist[nx][ny]) {

                    dist[nx][ny] = newUp;

                    if (nx < x) {
                        dq.addLast(new State(nx, ny, newUp));
                    } else {
                        dq.addFirst(new State(nx, ny, newUp));
                    }
                }
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dist[i][j] != Integer.MAX_VALUE) {
                    count++;
                }
            }
        }

        return count;
    }
}