import java.util.HashMap;

/**
 * The thief has found himself a new place for his thievery again.
 * There is only one entrance to this area, called the "root."
 * Besides the root, each house has one and only one parent house.
 * After a tour, the smart thief realized that "all houses in this place forms a binary tree".
 * It will automatically contact the police if two directly-linked houses were broken into on the same night.
 *
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * Example 2:
 *
 * Input: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 */
public class HouseRobberIII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * Brute for approach using recursion.
     */
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int robRoot = root.val;
        if (root.left != null) {
            robRoot += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            robRoot += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(robRoot, rob(root.left) + rob(root.right));
    }

    /**
     * Optimized dp solution using a map to store calculated results from bottom up to avoid recalculation.
     */
    public int rob1(TreeNode root) {
        return robHelper(root, new HashMap<>());
    }

    public int robHelper(TreeNode root, HashMap<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        int robRoot = root.val;
        if (root.left != null) {
            robRoot += robHelper(root.left.left, map) + robHelper(root.left.right, map);
        }
        if (root.right != null) {
            robRoot += robHelper(root.right.left, map) + robHelper(root.right.right, map);
        }
        robRoot = Math.max(robRoot, robHelper(root.left, map) + robHelper(root.right, map));
        map.put(root, robRoot);
        return robRoot;
    }

    /**
     * Optimized solution where the secret of the universe lies in.
     */
    public int rob2(TreeNode root) {
        int[] ans = robHelper1(root);
        return Math.max(ans[0], ans[1]);
    }

    public int[] robHelper1(TreeNode root) {
        if (root == null) return new int[2];
        int[] left = robHelper1(root.left);
        int[] right = robHelper1(root.right);
        int[] ans = new int[2];
        ans[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        ans[1] = root.val + left[0] + right[0];
        return ans;
    }
}
