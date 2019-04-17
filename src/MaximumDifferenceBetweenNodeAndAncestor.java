import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Given the root of a binary tree, find the maximum value V for
 * which there exists different nodes A and B where V = |A.val - B.val| and A is an ancestor of B.
 *
 * (A node A is an ancestor of B if either: any child of A is equal to B, or any child of A is an ancestor of B.)
 * Example 1:
 *
 * Input: [8,3,10,1,6,null,14,null,null,4,7,13]
 * Output: 7
 * Explanation:
 * We have various ancestor-node differences, some of which are given below :
 * |8 - 3| = 5
 * |3 - 7| = 4
 * |8 - 1| = 7
 * |10 - 13| = 3
 * Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.
 *
 *
 * Note:
 *
 * The number of nodes in the tree is between 2 and 5000.
 * Each node will have value between 0 and 100000.
 */
public class MaximumDifferenceBetweenNodeAndAncestor {
    int ans;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return ans;
    }

    private void dfs(TreeNode root, int min, int max) {
        if (root == null) return;
        int cur = Math.max(Math.abs(max - root.val), Math.abs(root.val - min));
        ans = Math.max(ans, cur);
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        dfs(root.left, min, max);
        dfs(root.right, min, max);
    }
}
