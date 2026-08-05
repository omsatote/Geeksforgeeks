class Solution:
    def countSubarray(self, arr, l, r):

        def count_leq(x):
            left = 0
            curr_sum = 0
            ans = 0

            for right in range(len(arr)):
                curr_sum += arr[right]

                while curr_sum > x:
                    curr_sum -= arr[left]
                    left += 1

                ans += right - left + 1

            return ans

        return count_leq(r) - count_leq(l - 1)