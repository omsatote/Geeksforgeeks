class Solution:
    def maxSumWithK(self, arr, k):
        n = len(arr)

        # maxEnd[i] = maximum subarray sum ending at i
        maxEnd = [0] * n
        maxEnd[0] = arr[0]

        for i in range(1, n):
            maxEnd[i] = max(arr[i], maxEnd[i - 1] + arr[i])

        # Sum of first k elements
        windowSum = sum(arr[:k])
        ans = windowSum

        for i in range(k, n):
            windowSum += arr[i] - arr[i - k]

            # Window of exactly k elements
            ans = max(ans, windowSum)

            # Extend with best prefix ending before the window
            ans = max(ans, windowSum + maxEnd[i - k])

        return ans