import java.util.HashMap;
import java.util.Map;

/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7

 */
public class ConstructBTFromInAndPostorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i += 1) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }

    private TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd, int[] postOrder, int poStart, int poEnd, Map<Integer, Integer> map) {
        if (inStart > inEnd || poStart > poEnd) return null;
        TreeNode root = new TreeNode(postOrder[poEnd]);
        int rootIndex = map.get(postOrder[poEnd]);
        root.left = buildTreeHelper(inorder, inStart, rootIndex - 1, postOrder, poStart, poStart + rootIndex - inStart - 1, map);
        root.right = buildTreeHelper(inorder, rootIndex + 1, inEnd, postOrder, poStart + rootIndex - inStart, poEnd - 1, map);
        return root;
    }

}
