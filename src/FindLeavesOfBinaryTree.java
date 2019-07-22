import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.
 *
 *
 *
 * Example:
 *
 * Input: [1,2,3,4,5]
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 *
 * Output: [[4,5,3],[2],[1]]
 *
 *
 * Explanation:
 *
 * 1. Removing the leaves [4,5,3] would result in this tree:
 *
 *           1
 *          /
 *         2
 *
 *
 * 2. Now removing the leaf [2] would result in this tree:
 *
 *           1
 *
 *
 * 3. Now removing the leaf [1] would result in the empty tree:
 *
 *           []
 */
public class FindLeavesOfBinaryTree {
    List<List<Integer>> ans;
    public List<List<Integer>> findLeaves(TreeNode root) {
        ans = new ArrayList<>();
        while (root != null) {
            List<Integer> temp = new ArrayList<>();
            root = remove(root, temp);
            ans.add(temp);
        }
        return ans;
    }
    private TreeNode remove(TreeNode cur, List<Integer> temp) {
        if (cur == null) return null;
        if (cur.left == null && cur.right == null) {
            temp.add(cur.val);
            return null;
        }
        cur.left = remove(cur.left, temp);
        cur.right = remove(cur.right, temp);
        return cur;
    }
}
