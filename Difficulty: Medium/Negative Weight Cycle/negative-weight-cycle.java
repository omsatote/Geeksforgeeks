class Solution {
    public boolean isNegativeWeightCycle(int V, int[][] edges) {

        // Initialize all distances to 0
        // This helps detect negative cycles in disconnected components too.
        long[] dist = new long[V];

        // Relax all edges V-1 times
        for (int i = 0; i < V - 1; i++) {
            boolean updated = false;

            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];

                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    updated = true;
                }
            }

            // No update means no negative cycle
            if (!updated) {
                break;
            }
        }

        // One more relaxation
        // If an update is still possible, negative cycle exists.
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (dist[u] + w < dist[v]) {
                return true;
            }
        }

        return false;
    }
}