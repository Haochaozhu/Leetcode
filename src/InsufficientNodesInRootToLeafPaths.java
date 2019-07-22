/**
 *
 */
public class InsufficientNodesInRootToLeafPaths {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        root = dfs(root, 0, limit);
        return root;
    }

    private TreeNode dfs(TreeNode cur, long sum, int limit) {
        if (cur == null) return null;
        if (cur.left == null && cur.right == null) {
            sum += cur.val;
            if (sum < limit) return null;
            return cur;
        }
        boolean leftOk = false;
        boolean rightOk = false;
        boolean leftOriginal = cur.left != null;
        boolean rightOriginal = cur.right != null;
        cur.left = dfs(cur.left, sum + cur.val, limit);
        cur.right = dfs(cur.right, sum + cur.val, limit);
        if (leftOriginal && cur.left != null) leftOk = true;
        if (rightOriginal && cur.right != null) rightOk = true;
        return (leftOk || rightOk) ? cur : null;
    }
}
