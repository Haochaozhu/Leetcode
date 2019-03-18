/*
236. Lowest Common Ancestor of a Binary Tree

 */
public class Problem236 {
    private TreeNode ans;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traverseTree(root, p, q);
        return ans;
    }

    private boolean traverseTree(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return false;
        int left = traverseTree(node.left, p, q) ? 1 : 0;
        int right = traverseTree(node.right, p, q) ? 1 : 0;
        int mid = (node == p || node == q) ? 1 : 0;
        if (left + right + mid == 2) ans = node;
        return left == 1 || right == 1 || mid == 1;
    }
}
