/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree
in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5

 */
public class ConvertSortedArrayToBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
  }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        TreeNode root = new TreeNode(nums[nums.length / 2]);
        root.left = sortedArrayToBSTHelper(nums, 0, nums.length / 2 - 1);
        root.right = sortedArrayToBSTHelper(nums, nums.length / 2 + 1, nums.length - 1);
        return root;
    }

    private TreeNode sortedArrayToBSTHelper(int[] nums, int lo, int hi) {
        if (hi < lo) return null;
        int index = (hi - lo) / 2 + lo;
        TreeNode node = new TreeNode(nums[index]);
        node.left = sortedArrayToBSTHelper(nums, lo, index - 1);
        node.right = sortedArrayToBSTHelper(nums, index + 1, hi);
        return node;
    }
}
