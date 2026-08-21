class Solution {
    public int transform(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return -1;
        }

        int n = s1.length();

        // Check whether both strings contain the same characters
        int[] freq = new int[256];

        for (int i = 0; i < n; i++) {
            freq[s1.charAt(i)]++;
            freq[s2.charAt(i)]--;
        }

        for (int x : freq) {
            if (x != 0) {
                return -1;
            }
        }

        // Find the longest suffix of s1 that is already
        // in the correct relative position in s2.
        int i = n - 1;
        int j = n - 1;

        while (i >= 0 && j >= 0) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i--;
                j--;
            } else {
                i--;
            }
        }

        return j + 1;
    }
}