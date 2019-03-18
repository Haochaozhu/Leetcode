import edu.princeton.cs.algs4.StdOut;

/*
Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true
Example 2:

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false
Example 3:

Input:     1        1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false

 */
public class SameTree {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        TreeNode pp = p;
        TreeNode qq = q;
        if (pp == null && qq == null) return true;
        if (pp == null || qq == null) return false;
        else if (pp.val != qq.val) return false;
        return isSameTree(pp.left, qq.left) && isSameTree(pp.right, qq.right);
    }

    public static void main(String[] args) {
        StdOut.println(true && false);
    }
}
