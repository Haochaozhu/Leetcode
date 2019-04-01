/**
 * Return the root node of a binary search tree that matches the given preorder traversal.
 *
 * (Recall that a binary search tree is a binary tree where for every node,
 * any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.
 * Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
 *
 *
 *
 * Example 1:
 *
 * Input: [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 *
 *
 *
 * Note:
 *
 * 1 <= preorder.length <= 100
 * The values of preorder are distinct.
 */
public class ConstructBSTFromPreorderTraversal {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 1) return new TreeNode(preorder[0]);
        return build(preorder, 0, preorder.length - 1);
    }

    private TreeNode build(int[] preorder, int lo, int hi) {
        if (lo == hi) return new TreeNode(preorder[lo]);
        if (lo > hi) return null;
        int rightStart = hi + 1;
        for (int i = lo; i <= hi; i += 1) {
            if (preorder[i] > preorder[lo]) {
                rightStart = i;
                break;
            }
        }
        TreeNode root = new TreeNode(preorder[lo]);
        root.left = build(preorder, lo + 1, rightStart - 1);
        root.right = build(preorder, rightStart, hi);
        return root;
    }
}
