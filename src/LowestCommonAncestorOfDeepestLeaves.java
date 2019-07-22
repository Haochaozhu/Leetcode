import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a rooted binary tree, find the lowest common ancestor of its deepest leaves.
 *
 * Recall that:
 *
 * The node of a binary tree is a leaf if and only if it has no children
 * The depth of the root of the tree is 0, and if the depth of a node is d, the depth of each of its children is d+1.
 * The lowest common ancestor of a set S of nodes is the node
 * A with the largest depth such that every node in S is in the subtree with root A.
 * Example 1:
 *
 * Input: root = [1,2,3]
 * Output: [1,2,3]
 * Example 2:
 *
 * Input: root = [1,2,3,4]
 * Output: [4]
 * Example 3:
 *
 * Input: root = [1,2,3,4,5]
 * Output: [2,4,5]
 */
public class LowestCommonAncestorOfDeepestLeaves {
    Set<Integer> set = new HashSet<>();
    int max = Integer.MIN_VALUE;
    TreeNode ans;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        getDepth(root, 0);
        getNode(root, 0);
        dfs(root);
        return ans;
    }
    private void getDepth(TreeNode cur, int depth) {
        if (cur == null) {
            return;
        }
        depth += 1;
        max = Math.max(max, depth);
        getDepth(cur.left, depth);
        getDepth(cur.right, depth);
    }

    private void getNode(TreeNode cur, int depth) {
        if (cur == null) return;
        depth += 1;
        if (depth == max) {
            set.add(cur.val);
        }
        getNode(cur.left, depth);
        getNode(cur.right, depth);
    }

    private int dfs(TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        int left = dfs(cur.left);
        int right = dfs(cur.right);
        int curVal = set.contains(cur.val) ? 1 : 0;
        if (left + right + curVal == set.size() && ans == null) {
            ans = cur;
        }
        return left + right + curVal;
    }
}
