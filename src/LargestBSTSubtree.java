/**
 * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.
 *
 * Note:
 * A subtree must include all of its descendants.
 *
 * Example:
 *
 * Input: [10,5,15,1,8,null,7]
 *
 *    10
 *    / \
 *   5  15
 *  / \   \
 * 1   8   7
 *
 * Output: 3
 * Explanation: The Largest BST Subtree in this case is the highlighted one.
 *              The return value is the subtree's size, which is 3.
 * Follow up:
 * Can you figure out ways to solve it with O(n) time complexity?
 */
public class LargestBSTSubtree {
    public int largestBSTSubtree(TreeNode root) {
        long[] ans = dfs(root);
        return (int)ans[2];
    }

    private long[] dfs(TreeNode root) {
        if (root == null) {
            return new long[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }
        long[] left = dfs(root.left);
        long[] right = dfs(root.right);
        if (root.val > left[1] && root.val < right[0]) {
            return new long[]{Math.min(root.val, left[0]), Math.max(root.val, right[1]), left[2] + right[2] + 1};
        } else {
            return new long[]{Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left[2], right[2])};
        }
    }
}
