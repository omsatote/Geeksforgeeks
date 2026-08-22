class Solution {

    boolean findPath(Node root, int value, StringBuilder path) {
        if (root == null)
            return false;

        if (root.data == value)
            return true;

        path.append('L');

        if (findPath(root.left, value, path))
            return true;

        path.deleteCharAt(path.length() - 1);

        path.append('R');

        if (findPath(root.right, value, path))
            return true;

        path.deleteCharAt(path.length() - 1);

        return false;
    }

    int numberOfTurns(Node root, int first, int second) {

        StringBuilder p1 = new StringBuilder();
        StringBuilder p2 = new StringBuilder();

        if (!findPath(root, first, p1) ||
            !findPath(root, second, p2)) {
            return -1;
        }

        int common = 0;

        while (common < p1.length() &&
               common < p2.length() &&
               p1.charAt(common) == p2.charAt(common)) {
            common++;
        }

        StringBuilder path = new StringBuilder();

        // first -> LCA
        for (int i = p1.length() - 1; i >= common; i--) {
            path.append(p1.charAt(i));
        }

        // LCA -> second
        for (int i = common; i < p2.length(); i++) {
            path.append(p2.charAt(i));
        }

        int turns = 0;

        for (int i = 1; i < path.length(); i++) {
            if (path.charAt(i) != path.charAt(i - 1)) {
                turns++;
            }
        }

        return turns == 0 ? -1 : turns;
    }
}