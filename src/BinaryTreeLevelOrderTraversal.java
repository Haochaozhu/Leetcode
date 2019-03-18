import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]

[[3],[9,20],[15,7]]
[[3],[9,9],[15,15],[]]

 */
public class BinaryTreeLevelOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> firstRow = new LinkedList<>();
        firstRow.add(root.val);
        ans.add(firstRow);

        while (!queue.isEmpty()) {
            List<Integer> curRow = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i += 1) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.add(temp.left);
                    curRow.add(temp.left.val);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                    curRow.add(temp.right.val);
                }
            }
            if (!curRow.isEmpty()) ans.add(curRow);
        }
        return ans;
    }

}
