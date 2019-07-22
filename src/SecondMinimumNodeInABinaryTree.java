import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Given a non-empty special binary tree consisting of nodes
 * with the non-negative value, where each node in this tree has exactly
 * two or zero sub-node. If the node has two sub-nodes,
 * then this node's value is the smaller value among its two sub-nodes.
 *
 * Given such a binary tree, you need to output the second minimum value
 * in the set made of all the nodes' value in the whole tree.
 *
 * If no such second minimum value exists, output -1 instead.
 *
 * Example 1:
 * Input:
 *     2
 *    / \
 *   2   5
 *      / \
 *     5   7
 *
 * Output: 5
 * Explanation: The smallest value is 2, the second smallest value is 5.
 * Example 2:
 * Input:
 *     2
 *    / \
 *   2   2
 *
 * Output: -1
 * Explanation: The smallest value is 2, but there isn't any second smallest value.
 */
public class SecondMinimumNodeInABinaryTree {
    Set<Integer> set = new HashSet<>();
    public int findSecondMinimumValue(TreeNode root) {
        dfs(root);
        int max = 0;
        int second = Integer.MIN_VALUE;
        for (int n : set) {
            if (n > max) {
                second = max;
                max = n;
            } else if (n > second) {
                second = n;
            }
        }
        return second == Integer.MIN_VALUE ? -1 : second;
    }
    private void dfs(TreeNode cur) {
        if (cur == null) return;
        set.add(cur.val);
        dfs(cur.left);
        dfs(cur.right);
    }

}
