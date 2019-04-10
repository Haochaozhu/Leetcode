import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]

 */
public class PathSumII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> cur = new LinkedList<>();
        addPath(ans, cur, root, sum);
        return ans;
    }

    private void addPath(List<List<Integer>> wrapper, List<Integer> lst, TreeNode node, int sum) {
        if (node == null) return;
        lst.add(node.val);
        if (node.left == null && node.right == null && node.val == sum) {
            wrapper.add(new LinkedList<>(lst));
        } else {
            addPath(wrapper, lst, node.left, sum - node.val);
            addPath(wrapper, lst, node.right, sum - node.val);
        }
        lst.remove(lst.size() - 1);

    }
}
