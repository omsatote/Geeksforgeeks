class Solution {
    public int findMax(int n) {
        String s = String.valueOf(n);
        int best = n;
        int bestSum = digitSum(n);

        for (int i = 0; i < s.length(); i++) {
            char[] arr = s.toCharArray();

            if (arr[i] == '0') {
                continue;
            }

            arr[i]--;

            for (int j = i + 1; j < arr.length; j++) {
                arr[j] = '9';
            }

            int candidate = Integer.parseInt(new String(arr));
            int sum = digitSum(candidate);

            if (sum > bestSum || (sum == bestSum && candidate > best)) {
                best = candidate;
                bestSum = sum;
            }
        }

        return best;
    }

    private int digitSum(int n) {
        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }
}