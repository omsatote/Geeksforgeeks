import java.util.*;

class Solution {

    public boolean areAnagrams(Node root1, Node root2) {

        if (root1 == null || root2 == null) {
            return root1 == root2;
        }

        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();

        q1.add(root1);
        q2.add(root2);

        while (!q1.isEmpty() && !q2.isEmpty()) {

            int size1 = q1.size();
            int size2 = q2.size();

            // Different number of nodes at this level
            if (size1 != size2) {
                return false;
            }

            HashMap<Integer, Integer> map = new HashMap<>();

            // Process first tree
            for (int i = 0; i < size1; i++) {
                Node node = q1.poll();

                map.put(node.data,
                        map.getOrDefault(node.data, 0) + 1);

                if (node.left != null) {
                    q1.add(node.left);
                }

                if (node.right != null) {
                    q1.add(node.right);
                }
            }

            // Process second tree
            for (int i = 0; i < size2; i++) {
                Node node = q2.poll();

                if (!map.containsKey(node.data)) {
                    return false;
                }

                map.put(node.data, map.get(node.data) - 1);

                if (map.get(node.data) == 0) {
                    map.remove(node.data);
                }

                if (node.left != null) {
                    q2.add(node.left);
                }

                if (node.right != null) {
                    q2.add(node.right);
                }
            }

            // Frequencies don't match
            if (!map.isEmpty()) {
                return false;
            }
        }

        // Both trees should finish together
        return q1.isEmpty() && q2.isEmpty();
    }
}