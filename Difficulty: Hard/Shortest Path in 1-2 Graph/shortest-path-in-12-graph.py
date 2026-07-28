import heapq

class Solution:
    def shortestPath(self, V, src, dest, edges):
        adj = [[] for _ in range(V)]

        for u, v, w in edges:
            adj[u].append((v, w))
            adj[v].append((u, w))

        INF = float('inf')
        dist = [INF] * V
        dist[src] = 0

        pq = [(0, src)]

        while pq:
            d, u = heapq.heappop(pq)

            if d != dist[u]:
                continue

            for v, w in adj[u]:
                if dist[v] > d + w:
                    dist[v] = d + w
                    heapq.heappush(pq, (dist[v], v))

        return -1 if dist[dest] == INF else dist[dest]