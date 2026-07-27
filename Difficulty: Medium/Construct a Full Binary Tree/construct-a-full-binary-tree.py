class Solution:
    def constructBinaryTree(self, pre, preMirror):
        n = len(pre)

        pos = {}
        for i in range(n):
            pos[preMirror[i]] = i

        self.idx = 0

        def build(l, r):
            if self.idx >= n or l > r:
                return None

            root = Node(pre[self.idx])
            self.idx += 1

            if l == r or self.idx >= n:
                return root

            nxt = pre[self.idx]
            mid = pos[nxt]

            root.left = build(mid, r)
            root.right = build(l + 1, mid - 1)

            return root

        return build(0, n - 1)