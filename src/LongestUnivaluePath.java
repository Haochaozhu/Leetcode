/**
 * Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 *
 * Example 1:
 *
 * Input:
 *
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * Output:
 *
 * 2
 * Example 2:
 *
 * Input:
 *
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * Output:
 *
 * 2
 * Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.
 */
public class LongestUnivaluePath {
    int maxL = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        traversal(root, root.val);
        return maxL;
    }

    private int traversal(TreeNode root, int rootVal) {
        if (root == null) return 0;
        int left = traversal(root.left, root.val);
        int right = traversal(root.right, root.val);
        maxL = Math.max(maxL, left + right);
        if (root.val == rootVal) return 1 + Math.max(left, right);
        return 0;
    }

}
