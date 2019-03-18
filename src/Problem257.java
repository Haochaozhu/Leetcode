import java.util.LinkedList;
import java.util.List;

/*
257. Binary Tree Paths
Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3

 */
public class Problem257 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        if (root != null) constructPath(root, "", res);
        return res;
    }

    private void constructPath(TreeNode node, String path, List res) {
        if (node.left == null && node.right == null) res.add(path + node.val);
        if (node.left != null) constructPath(node.left, path + node.val + "->", res);
        if (node.right != null) constructPath(node.right, path + + node.val + "->", res);
    }
}
