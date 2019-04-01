import java.util.Stack;

/**
 * Given a Binary Search Tree (BST), convert it to a Greater Tree
 * such that every key of the original BST is changed to the original key
 * plus sum of all keys greater than the original key in BST.
 *
 * Example:
 *
 * Input: The root of a Binary Search Tree like this:
 *               5
 *             /   \
 *            2     13
 *
 * Output: The root of a Greater Tree like this:
 *              18
 *             /   \
 *           20     13
 */
public class ConvertBSTToGreaterTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode convertBST(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        int curSum = 0;
        while (cur != null || !st.isEmpty()) {
            while (cur != null) {
                st.push(cur);
                cur = cur.right;
            }
            cur = st.pop();
            curSum += cur.val;
            cur.val = curSum;
            cur = cur.left;
        }
        return root;
    }
}
