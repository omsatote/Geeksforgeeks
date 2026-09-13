import java.util.*;

class Solution {
    public int partyHouse(ArrayList<ArrayList<Integer>> adj) {
        int[] a = bfs(1, adj);
        int[] b = bfs(a[0], adj);

        return (b[1] + 1) / 2;
    }

    private int[] bfs(int start, ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 0;

        int farthest = start;

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v : adj.get(u - 1)) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.add(v);

                    if (dist[v] > dist[farthest]) {
                        farthest = v;
                    }
                }
            }
        }

        return new int[]{farthest, dist[farthest]};
    }
}