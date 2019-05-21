import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary tree with n nodes, your task is to check if it's possible to partition the tree to two
 * trees which have the equal sum of values after removing exactly one edge on the original tree.
 *
 * Example 1:
 * Input:
 *     5
 *    / \
 *   10 10
 *     /  \
 *    2   3
 *
 * Output: True
 * Explanation:
 *     5
 *    /
 *   10
 *
 * Sum: 15
 *
 *    10
 *   /  \
 *  2    3
 *
 * Sum: 15
 * Example 2:
 * Input:
 *     1
 *    / \
 *   2  10
 *     /  \
 *    2   20
 *
 * Output: False
 * Explanation: You can't split the tree into two trees with equal sum after removing exactly one edge on the tree.
 * Note:
 * The range of tree node value is in the range of [-100000, 100000].
 * 1 <= n <= 10000
 */
public class EqualTreePartition {
    public boolean checkEqualTree(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = sum(root, map);
        if ((sum & 1) == 1) return false;
        if (sum == 0) return map.get(0) > 1;
        else return map.containsKey(sum / 2);
    }
    private int sum(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) return 0;
        int curSum = sum(node.left, map) + sum(node.right, map) + node.val;
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        return curSum;
    }
}
