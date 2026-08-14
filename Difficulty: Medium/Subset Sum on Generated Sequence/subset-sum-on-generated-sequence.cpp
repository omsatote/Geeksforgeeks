class Solution {
  public:
    bool isPossible(vector<int>& arr, int s, int x) {
        if (x == 0) return true;

        long long total = s;
        vector<long long> paper = {s};
        int n = arr.size(), i = 0;

        // Numbers roughly double each step, so this generates
        // at most ~30 terms before exceeding x (<=1e9), regardless of n.
        while (i < n && total <= x) {
            long long p = total + arr[i];
            paper.push_back(p);
            total += p;
            i++;
        }

        // Greedy subset-sum on a super-increasing sequence
        long long remaining = x;
        for (int j = (int)paper.size() - 1; j >= 0; j--) {
            if (paper[j] <= remaining) remaining -= paper[j];
        }

        return remaining == 0;
    }
};