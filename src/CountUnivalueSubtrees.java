/**
 * Given a binary tree, count the number of uni-value subtrees.
 *
 * A Uni-value subtree means all nodes of the subtree have the same value.
 *
 * Example :
 *
 * Input:  root = [5,1,5,5,5,null,5]
 *
 *               5
 *              / \
 *             1   5
 *            / \   \
 *           5   5   5
 *
 * Output: 4
 */
public class CountUnivalueSubtrees {
    int ans;
    public int countUnivalSubtrees(TreeNode root) {
        dfs(root);
        return ans;
    }

    private boolean dfs(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            ans++;
            return true;
        }
        boolean curL = true;
        boolean curR = true;
        if (root.left != null) {
            curL = root.val == root.left.val;
        }
        if (root.right != null) {
            curR = root.val == root.right.val;
        }
        boolean l = dfs(root.left);
        boolean r = dfs(root.right);
        if (l && r && curL && curR) {
            ans++;
            return true;
        } else {
            return false;
        }
    }
}
