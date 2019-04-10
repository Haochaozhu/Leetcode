/**
 * Given a binary tree, each node has value 0 or 1.
 * Each root-to-leaf path represents a binary number starting with the most significant bit.
 * For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary,
 * which is 13.
 *
 * For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
 *
 * Return the sum of these numbers modulo 10^9 + 7.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: [1,0,1,0,1,0,1]
 * Output: 22
 * Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 *
 *
 * Note:
 *
 * The number of nodes in the tree is between 1 and 1000.
 * node.val is 0 or 1.
 */
public class SumOfRootToLeafBinaryNumbers {
    long sum;
    public int sumRootToLeaf(TreeNode root) {
        sum = 0;
        findSum(root, 0L);
        return (int)(sum % 1000000007);
    }

    private void findSum(TreeNode root, long n) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            sum += n * 2 + root.val;
            return;
        }
        findSum(root.left, (n * 2 + root.val) % 1000000007);
        findSum(root.right, (n * 2 + root.val) % 1000000007);
    }

}
