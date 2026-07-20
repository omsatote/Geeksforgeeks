class Solution {

    static class TrieNode {
        TrieNode[] child = new TrieNode[26];
        int freq = 0;
    }

    TrieNode root = new TrieNode();

    // Insert a word into the trie
    void insert(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (curr.child[idx] == null) {
                curr.child[idx] = new TrieNode();
            }
            curr = curr.child[idx];
            curr.freq++;
        }
    }

    // Find the shortest unique prefix
    String findPrefix(String word) {
        TrieNode curr = root;
        StringBuilder prefix = new StringBuilder();

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            curr = curr.child[idx];
            prefix.append(ch);

            if (curr.freq == 1) {
                break;
            }
        }
        return prefix.toString();
    }

    public ArrayList<String> findPrefixes(String[] arr) {
        root = new TrieNode();

        // Insert all words
        for (String word : arr) {
            insert(word);
        }

        ArrayList<String> ans = new ArrayList<>();

        // Find unique prefix for each word
        for (String word : arr) {
            ans.add(findPrefix(word));
        }

        return ans;
    }
}