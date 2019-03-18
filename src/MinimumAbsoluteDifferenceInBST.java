/*
Given a binary search tree with non-negative values,
find the minimum absolute difference between values of any two nodes.

Example:

Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).

 */

import java.util.Map;
import java.util.Stack;

public class MinimumAbsoluteDifferenceInBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    TreeNode prev;
    int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return min;
        getMinimumDifference(root.left);
        if (prev != null) {
            min = Math.min(min, root.val - prev.val);
            prev = root;
        }
        getMinimumDifference(root.right);
        return min;
    }

}
