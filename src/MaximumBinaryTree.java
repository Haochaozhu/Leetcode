/**
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
 *
 * The root is the maximum number in the array.
 * The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 * The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 * Construct the maximum tree by the given array and output the root node of this tree.
 *
 * Example 1:
 * Input: [3,2,1,6,0,5]
 * Output: return the tree root node representing the following tree:
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *       \
 *        1
 * Note:
 * The size of the given array will be in the range [1,1000].
 */
public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return findMaximum(nums, 0, nums.length - 1);
    }

    private TreeNode findMaximum(int[] nums, int lo, int hi) {
        if (lo > hi) return null;
        int maxIndex = 0;
        int max = Integer.MIN_VALUE;
        for (int i = lo; i <= hi; i += 1) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = findMaximum(nums, lo, maxIndex - 1);
        root.right = findMaximum(nums, maxIndex + 1, hi);
        return root;
    }
}
