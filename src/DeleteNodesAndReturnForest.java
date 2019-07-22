import java.util.List;

/**
 * Given the root of a binary tree, each node in the tree has a distinct value.
 *
 * After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
 *
 * Return the roots of the trees in the remaining forest.  You may return the result in any order.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * Output: [[1,2,null,4],[6],[7]]
 *
 *
 * Constraints:
 *
 * The number of nodes in the given tree is at most 1000.
 * Each node has a distinct value between 1 and 1000.
 * to_delete.length <= 1000
 * to_delete contains distinct values between 1 and 1000.
 */
import java.util.*;
public class DeleteNodesAndReturnForest {
    List<TreeNode> ans;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int n : to_delete) {
            set.add(n);
        }
        if (!set.contains(root.val)) ans.add(root);
        dfs(root, set, null, false);
        return ans;
    }

    private void dfs(TreeNode cur, Set<Integer> set, TreeNode parent, boolean left) {
        if (cur == null) {
            return;
        }
        if (set.contains(cur.val)) {
            if (parent != null) {
                if (left) parent.left = null;
                else parent.right = null;
            }
            if (cur.left != null && !set.contains(cur.left.val)) {
                ans.add(cur.left);
            }
            if (cur.right != null && !set.contains(cur.right.val)) {
                ans.add(cur.right);
            }
        }
        dfs(cur.left, set, cur, true);
        dfs(cur.right, set, cur, false);
    }
}
