from collections import deque

class Solution:
    def maxDistance(self, V, src, edges):
        adj = [[] for _ in range(V)]
        indegree = [0] * V

        for u, v, w in edges:
            adj[u].append((v, w))
            indegree[v] += 1

        # Topological Sort
        q = deque()
        for i in range(V):
            if indegree[i] == 0:
                q.append(i)

        topo = []
        while q:
            u = q.popleft()
            topo.append(u)
            for v, w in adj[u]:
                indegree[v] -= 1
                if indegree[v] == 0:
                    q.append(v)

        INT_MIN = -(1 << 31)
        dist = [INT_MIN] * V
        dist[src] = 0

        for u in topo:
            if dist[u] == INT_MIN:
                continue
            for v, w in adj[u]:
                if dist[u] + w > dist[v]:
                    dist[v] = dist[u] + w

        return dist