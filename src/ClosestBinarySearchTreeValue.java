/**
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 *
 * Note:
 *
 * Given target value is a floating point.
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 * Example:
 *
 * Input: root = [4,2,5,1,3], target = 3.714286
 *
 *     4
 *    / \
 *   2   5
 *  / \
 * 1   3
 *
 * Output: 4
 */
public class ClosestBinarySearchTreeValue {
    double diff = Double.MAX_VALUE;
    int ans;
    public int closestValue(TreeNode root, double target) {
        dfs(root, target);
        return ans;
    }
    private void dfs(TreeNode node, double target) {
        if (node == null) return;
        dfs(node.left, target);
        dfs(node.right, target);
        double curDiff = Math.abs(node.val * 1.0 - target);
        if (curDiff < diff) {
            diff = curDiff;
            ans = node.val;
        }
    }
}
