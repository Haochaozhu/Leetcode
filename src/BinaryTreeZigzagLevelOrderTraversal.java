import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given a binary tree, return the zigzag level order
traversal of its nodes' values. (ie, from left to right,
then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]

 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return ans;
        boolean addFirst = false;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> tempList = new LinkedList<>();
            for (int i = 0; i < size; i += 1) {
                TreeNode temp = q.remove();
                if (addFirst) tempList.addFirst(temp.val);
                else tempList.add(temp.val);
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            }
            addFirst = !addFirst;
            ans.add(tempList);
        }
        return ans;
    }
}
