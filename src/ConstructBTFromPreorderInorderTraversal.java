import java.util.HashMap;
import java.util.Map;

/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7

 */
public class ConstructBTFromPreorderInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer>  map = new HashMap<>();
        for (int i = 0; i < inorder.length; i += 1) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private TreeNode buildTreeHelper(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(pre[preStart]);
        int inRoot = map.get(pre[preStart]);
        int numsLeft = inRoot - inStart;
        root.left = buildTreeHelper(pre, preStart + 1, preStart + numsLeft, in, inStart, inRoot - 1, map);
        root.right = buildTreeHelper(pre, preStart + numsLeft + 1, preEnd, in, inRoot + 1, inEnd, map);
        return root;
    }

}
