import java.util.HashMap;
import java.util.Map;

/**
 * If the depth of a tree is smaller than 5, then this tree can be
 * represented by a list of three-digits integers.
 *
 * For each integer in this list:
 * The hundreds digit represents the depth D of this node, 1 <= D <= 4.
 * The tens digit represents the position P of this node in the level it belongs to, 1 <= P <= 8.
 * The position is the same as that in a full binary tree.
 * The units digit represents the value V of this node, 0 <= V <= 9.
 * Given a list of ascending three-digits integers representing a binary with the depth smaller than 5.
 * You need to return the sum of all paths from the root towards the leaves.
 *
 * Example 1:
 * Input: [113, 215, 221]
 * Output: 12
 * Explanation:
 * The tree that the list represents is:
 *     3
 *    / \
 *   5   1
 *
 * The path sum is (3 + 5) + (3 + 1) = 12.
 * Example 2:
 * Input: [113, 221]
 * Output: 4
 * Explanation:
 * The tree that the list represents is:
 *     3
 *      \
 *       1
 *
 * The path sum is (3 + 1) = 4.
 */
public class PathSumIV {
    int sum = 0;
    Map<Integer, Integer> tree;
    public int pathSum(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        tree = new HashMap<>();
        for (int n : nums) {
            int val = n % 10;
            int pos = n / 10;
            tree.putIfAbsent(pos, val);
        }
        dfs(nums[0] / 10, 0);
        return sum;
    }

    private void dfs(int cur, int preSum) {
        int pos = cur % 10;
        int level = cur / 10;
        int curSum = preSum + tree.get(cur);
        int left = (level + 1) * 10 + pos * 2 - 1;
        int right = (level + 1) * 10 + pos * 2;
        if (!tree.containsKey(left) && !tree.containsKey(right)) {
            sum += curSum;
            return;
        }
        if (tree.containsKey(left)) dfs(left, curSum);
        if (tree.containsKey(right)) dfs(right, curSum);
    }
}
