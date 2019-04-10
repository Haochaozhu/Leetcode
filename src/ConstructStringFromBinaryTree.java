/**
 * You need to construct a string consists of parenthesis and integers
 * from a binary tree with the preorder traversing way.
 *
 * The null node needs to be represented by empty parenthesis pair "()".
 * And you need to omit all the empty parenthesis pairs that
 * don't affect the one-to-one mapping relationship between the string and the original binary tree.
 *
 * Example 1:
 * Input: Binary tree: [1,2,3,4]
 *        1
 *      /   \
 *     2     3
 *    /
 *   4
 *
 * Output: "1(2(4))(3)"
 *
 * Explanation: Originallay it needs to be "1(2(4)())(3()())",
 * but you need to omit all the unnecessary empty parenthesis pairs.
 * And it will be "1(2(4))(3)".
 * Example 2:
 * Input: Binary tree: [1,2,3,null,4]
 *        1
 *      /   \
 *     2     3
 *      \
 *       4
 *
 * Output: "1(2()(4))(3)"
 *
 * Explanation: Almost the same as the first example,
 * except we can't omit the first parenthesis pair to break the
 * one-to-one mapping relationship between the input and the output.
 */
public class ConstructStringFromBinaryTree {
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(t.val);
        preorder(t.left, sb, t.left == null, t.right == null);
        preorder(t.right, sb, t.left == null, t.right == null);
        return sb.toString();
    }
    private void preorder(TreeNode root, StringBuilder sb, boolean leftChild, boolean rightChild) {
        if (leftChild && rightChild) return;
        if (root == null) {
            if (leftChild) {
                sb.append("()");
                return;
            }
            if (rightChild) {
                return;
            }
        }
        sb.append("(" + root.val);
        preorder(root.left, sb, root.left == null, root.right == null);
        preorder(root.right, sb, root.left == null, root.right == null);
        sb.append(")");
    }

}

