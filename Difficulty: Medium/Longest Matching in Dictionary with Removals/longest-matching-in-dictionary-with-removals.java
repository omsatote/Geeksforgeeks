import java.util.*;

class Solution {
    public String findLongestWord(String s, List<String> d) {
        ArrayList<Integer>[] pos = new ArrayList[26];

        for (int i = 0; i < 26; i++) {
            pos[i] = new ArrayList<>();
        }

        for (int i = 0; i < s.length(); i++) {
            pos[s.charAt(i) - 'a'].add(i);
        }

        String ans = "";

        for (String word : d) {
            if (isSubsequence(word, pos)) {
                if (word.length() > ans.length() ||
                    (word.length() == ans.length() && word.compareTo(ans) < 0)) {
                    ans = word;
                }
            }
        }

        return ans;
    }

    private boolean isSubsequence(String word, ArrayList<Integer>[] pos) {
        int previous = -1;

        for (int i = 0; i < word.length(); i++) {
            ArrayList<Integer> list = pos[word.charAt(i) - 'a'];

            int left = 0;
            int right = list.size();

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (list.get(mid) <= previous) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            if (left == list.size()) {
                return false;
            }

            previous = list.get(left);
        }

        return true;
    }
}