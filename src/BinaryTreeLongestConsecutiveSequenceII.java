/**
 * Given a binary tree, you need to find the length of Longest Consecutive Path in Binary Tree.
 *
 * Especially, this path can be either increasing or decreasing. For example, [1,2,3,4] and [4,3,2,1] are both considered valid, but the path [1,2,4,3] is not valid. On the other hand, the path can be in the child-Parent-child order, where not necessarily be parent-child order.
 *
 * Example 1:
 *
 * Input:
 *         1
 *        / \
 *       2   3
 * Output: 2
 * Explanation: The longest consecutive path is [1, 2] or [2, 1].
 *
 *
 * Example 2:
 *
 * Input:
 *         2
 *        / \
 *       1   3
 * Output: 3
 * Explanation: The longest consecutive path is [1, 2, 3] or [3, 2, 1].
 *
 *
 * Note: All the values of tree nodes are in the range of [-1e7, 1e7].
 */
public class BinaryTreeLongestConsecutiveSequenceII {
    class Solution {
        int ans;
        public int longestConsecutive(TreeNode root) {
            dfs(root);
            return ans;
        }

        private int[] dfs(TreeNode cur) {
            if (cur == null) return null;
            int[] l = dfs(cur.left);
            int[] r = dfs(cur.right);
            int leftUp = 0, leftDown = 0, rightUp = 0, rightDown = 0;
            if (cur.left != null) {
                if (cur.val == cur.left.val + 1) {
                    leftUp = l[0];
                }
                if (cur.val == cur.left.val - 1) {
                    leftDown = l[1];
                }
            }
            if (cur.right != null) {
                if (cur.val == cur.right.val + 1) {
                    rightUp = r[0];
                }
                if (cur.val == cur.right.val - 1) {
                    rightDown = r[1];
                }
            }
            ans = Math.max(ans, Math.max(leftUp + rightDown, leftDown + rightUp) + 1);
            return new int[]{Math.max(leftUp, rightUp) + 1, Math.max(leftDown, rightDown) + 1};
        }
    }}
