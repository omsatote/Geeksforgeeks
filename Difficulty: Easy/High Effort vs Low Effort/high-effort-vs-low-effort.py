class Solution:
    def maxTask(self, h, l):
        n = len(h)

        if n == 1:
            return max(h[0], l[0])

        prev2 = 0
        prev1 = max(h[0], l[0])

        for i in range(1, n):
            curr = max(prev1 + l[i], prev2 + h[i])
            prev2 = prev1
            prev1 = curr

        return prev1