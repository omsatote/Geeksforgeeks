class Solution:
    def minEdgesReq(self, n, edges):
        if len(edges) < n - 1:
            return -1

        parent = list(range(n))
        rank = [0] * n

        def find(x):
            while parent[x] != x:
                parent[x] = parent[parent[x]]
                x = parent[x]
            return x

        def union(x, y):
            px, py = find(x), find(y)
            if px == py:
                return
            if rank[px] < rank[py]:
                parent[px] = py
            elif rank[px] > rank[py]:
                parent[py] = px
            else:
                parent[py] = px
                rank[px] += 1

        for u, v in edges:
            union(u, v)

        components = 0
        for i in range(n):
            if find(i) == i:
                components += 1

        return components - 1