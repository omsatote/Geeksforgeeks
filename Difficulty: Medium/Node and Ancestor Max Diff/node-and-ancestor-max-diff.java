class Solution {

    int maxDiff(Node root) {
        if (root == null) {
            return 0;
        }

        int ans = Integer.MIN_VALUE;

        if (root.left != null) {
            ans = Math.max(ans, findMax(root.left, root.data));
        }

        if (root.right != null) {
            ans = Math.max(ans, findMax(root.right, root.data));
        }

        return ans;
    }

    int findMax(Node node, int maxAncestor) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        int currentDiff = maxAncestor - node.data;

        int newMaxAncestor = Math.max(maxAncestor, node.data);

        int left = findMax(node.left, newMaxAncestor);
        int right = findMax(node.right, newMaxAncestor);

        return Math.max(currentDiff, Math.max(left, right));
    }
}