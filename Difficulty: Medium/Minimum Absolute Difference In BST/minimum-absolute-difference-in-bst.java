class Solution {
    int prev = -1;
    int ans = Integer.MAX_VALUE;

    public int absDiff(Node root) {
        inorder(root);
        return ans;
    }

    void inorder(Node root) {
        if (root == null) {
            return;
        }

        // Traverse left subtree
        inorder(root.left);

        // Compare with previous node
        if (prev != -1) {
            ans = Math.min(ans, root.data - prev);
        }

        // Update previous value
        prev = root.data;

        // Traverse right subtree
        inorder(root.right);
    }
}