import java.util.LinkedList;
import java.util.Stack;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * Example 1:
 *
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * Output: 3
 * Follow up:
 * What if the BST is modified (insert/delete operations) often
 * and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 */
public class KthSmallestElementInABST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * Brute force solution. Use inorder traversal to generate a sorted sequence.
     */
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        traversal(root, list);
        return list.get(k);
    }
    private void traversal(TreeNode node, LinkedList<Integer> list) {
        if (node == null) return;
        traversal(node.left, list);
        list.add(node.val);
        traversal(node.right, list);
    }

}
