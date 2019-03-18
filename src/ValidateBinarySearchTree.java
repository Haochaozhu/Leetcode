import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:

Input:
    2
   / \
  1   3
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6
Output: false
Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
             is 5 but its right child's value is 4.

 */
public class ValidateBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isValidBST(TreeNode root) {
        LinkedList<Integer> q = new LinkedList<>();
        convert(root, q);
        for (int i = 0; i < q.size() - 1; i += 1) {
            if (q.get(i) > q.get(i + 1)) return false;
        }
        return true;
    }
    private void convert(TreeNode node, Queue q) {
        if (node == null) return;
        convert(node.left, q);
        q.add(node.val);
        convert(node.right, q);
    }

    public boolean isValidBSTIter(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode prev = null;
        while (root != null || !st.isEmpty()) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if (prev != null && prev.val >= root.val) return false;
            prev = root;
            root = root.right;
        }
        return true;
    }
}
