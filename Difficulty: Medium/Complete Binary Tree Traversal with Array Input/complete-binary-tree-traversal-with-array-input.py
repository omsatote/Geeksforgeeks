class Solution:
    def levelSort(self, arr):
        ans = []
        n = len(arr)
        index = 0
        level_size = 1

        while index < n:
            level = []

            for _ in range(level_size):
                if index >= n:
                    break
                level.append(arr[index])
                index += 1

            level.sort()
            ans.append(level)
            level_size *= 2

        return ans