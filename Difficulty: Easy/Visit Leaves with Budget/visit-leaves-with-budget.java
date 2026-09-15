import java.util.*;

class Solution {
    public int getCount(Node root, int k) {
        if (root == null) {
            return 0;
        }

        ArrayList<Integer> leaves = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();

        q.add(root);
        level.add(1);

        while (!q.isEmpty()) {
            Node node = q.poll();
            int l = level.poll();

            if (node.left == null && node.right == null) {
                leaves.add(l);
            }

            if (node.left != null) {
                q.add(node.left);
                level.add(l + 1);
            }

            if (node.right != null) {
                q.add(node.right);
                level.add(l + 1);
            }
        }

        Collections.sort(leaves);

        int count = 0;

        for (int cost : leaves) {
            if (cost > k) {
                break;
            }

            k -= cost;
            count++;
        }

        return count;
    }
}