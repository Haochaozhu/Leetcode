import java.util.*;

/**
 * Given a binary tree where every node has a unique value, and a target key k, find the value of the nearest leaf node to target k in the tree.
 *
 * Here, nearest to a leaf means the least number of edges travelled on the binary tree to reach any leaf of the tree. Also, a node is called a leaf if it has no children.
 *
 * In the following examples, the input tree is represented in flattened form row by row. The actual root tree given will be a TreeNode object.
 *
 * Example 1:
 *
 * Input:
 * root = [1, 3, 2], k = 1
 * Diagram of binary tree:
 *           1
 *          / \
 *         3   2
 *
 * Output: 2 (or 3)
 *
 * Explanation: Either 2 or 3 is the nearest leaf node to the target of 1.
 * Example 2:
 *
 * Input:
 * root = [1], k = 1
 * Output: 1
 *
 * Explanation: The nearest leaf node is the root node itself.
 * Example 3:
 *
 * Input:
 * root = [1,2,3,4,null,null,null,5,null,6], k = 2
 * Diagram of binary tree:
 *              1
 *             / \
 *            2   3
 *           /
 *          4
 *         /
 *        5
 *       /
 *      6
 *
 * Output: 3
 * Explanation: The leaf node with value 3 (and not the leaf node with value 6) is nearest to the node with value 2.
 * Note:
 * root represents a binary tree with at least 1 node and at most 1000 nodes.
 * Every node has a unique node.val in range [1, 1000].
 * There exists some node in the given binary tree for which node.val == k.
 */
public class ClosestLeafInABinaryTree {
    private TreeNode target;
    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        buildMap(map, root, null, k);
        Queue<TreeNode> que = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        visited.add(target.val);
        que.add(target);
        while (!que.isEmpty()) {
            TreeNode cur = que.poll();
            TreeNode parent = map.get(cur);
            if (cur.left == null && cur.right == null) return cur.val;
            if (cur.left != null && !visited.contains(cur.left.val)) {
                que.offer(cur.left);
                visited.add(cur.left.val);
            }
            if (cur.right != null && !visited.contains(cur.right.val)) {
                que.offer(cur.right);
                visited.add(cur.right.val);
            }
            if (parent != null && !visited.contains(parent.val)) {
                que.offer(parent);
                visited.add(parent.val);
            }
        }
        return -1;
    }
    private void buildMap(Map<TreeNode, TreeNode> map, TreeNode cur, TreeNode parent, int k) {
        if (cur == null) return;
        if (cur.val == k) target = cur;
        map.put(cur, parent);
        buildMap(map, cur.left, cur, k);
        buildMap(map, cur.right, cur, k);
    }
}
