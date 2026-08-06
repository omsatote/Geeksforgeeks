class Solution:
    def countMinOperations(self, arr):
        operations = 0

        while True:
            all_zero = True

            for i in range(len(arr)):
                if arr[i] % 2 == 1:
                    arr[i] -= 1
                    operations += 1
                if arr[i] != 0:
                    all_zero = False

            if all_zero:
                break

            for i in range(len(arr)):
                arr[i] //= 2

            operations += 1

        return operations