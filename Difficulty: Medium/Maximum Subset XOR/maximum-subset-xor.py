class Solution:
    def maxSubsetXOR(self, arr):
        n = len(arr)
        index = 0

        # Build XOR basis
        for bit in range(31, -1, -1):
            pivot = -1
            for i in range(index, n):
                if arr[i] & (1 << bit):
                    pivot = i
                    break

            if pivot == -1:
                continue

            arr[index], arr[pivot] = arr[pivot], arr[index]

            for i in range(n):
                if i != index and (arr[i] & (1 << bit)):
                    arr[i] ^= arr[index]

            index += 1

        # Find maximum XOR
        ans = 0
        for i in range(index):
            ans = max(ans, ans ^ arr[i])

        return ans