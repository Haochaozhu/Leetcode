import java.util.LinkedList;
import java.util.Queue;

/**
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 *
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 *
 * We are given the root of a binary tree with unique values,
 * and the values x and y of two different nodes in the tree.
 *
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 * Note:
 *
 * The number of nodes in the tree will be between 2 and 100.
 * Each node has a unique integer value from 1 to 100.
 */
public class CousinsInBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isX = false;
            boolean isY = false;
            for (int i = 0; i < size; i += 1) {
                TreeNode cur = queue.remove();
                if (cur.val == x) isX = true;
                if (cur.val == y) isY = true;
                if (cur.left != null && cur.right != null) {
                    if (cur.left.val == x && cur.right.val == y) return false;
                    if (cur.left.val == y && cur.right.val == x) return false;
                }
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            if (isX && isY) return true;
        }
        return false;
    }
}
