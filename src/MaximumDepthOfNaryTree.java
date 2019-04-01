import java.util.List;

/**
 * Given a n-ary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path
 * from the root node down to the farthest leaf node.
 *
 * For example, given a 3-ary tree:
 **
 * We should return its max depth, which is 3.
 */
public class MaximumDepthOfNaryTree {
    class Node {
        public int val;
        public List<Node> children;
        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int max = 0;
        for (Node child : root.children) { //replace left&right to for loop
            int value = maxDepth(child);

            if (value > max) {
                max = value;
            }
        }
        return max +1;
    }

}
