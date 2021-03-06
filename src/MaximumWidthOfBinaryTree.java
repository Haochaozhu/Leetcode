import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.
 *
 * The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.
 *
 * Example 1:
 *
 * Input:
 *
 *            1
 *          /   \
 *         3     2
 *        / \     \
 *       5   3     9
 *
 * Output: 4
 * Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
 * Example 2:
 *
 * Input:
 *
 *           1
 *          /
 *         3
 *        / \
 *       5   3
 *
 * Output: 2
 * Explanation: The maximum width existing in the third level with the length 2 (5,3).
 * Example 3:
 *
 * Input:
 *
 *           1
 *          / \
 *         3   2
 *        /
 *       5
 *
 * Output: 2
 * Explanation: The maximum width existing in the second level with the length 2 (3,2).
 * Example 4:
 *
 * Input:
 *
 *           1
 *          / \
 *         3   2
 *        /     \
 *       5       9
 *      /         \
 *     6           7
 * Output: 8
 * Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
 *
 *
 * Note: Answer will in the range of 32-bit signed integer.
 */
public class MaximumWidthOfBinaryTree {
    int max = 0;
    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 0, 1, new ArrayList<>());
        return max;
    }

    private void dfs(TreeNode cur, int d, int id, List<Integer> leftMost) {
        if (cur == null) return;
        if (d >= leftMost.size()) {
            leftMost.add(id);
        }
        max = Math.max(max, id - leftMost.get(d) + 1);
        dfs(cur.left, d + 1, id * 2, leftMost);
        dfs(cur.right, d + 1, id * 2 + 1, leftMost);
    }
}
