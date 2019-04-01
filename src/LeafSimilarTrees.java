import java.util.ArrayList;

/**
 * Consider all the leaves of a binary tree.
 * From left to right order, the values of those leaves form a leaf value sequence.
 *
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 *
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 *
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 *
 *
 *
 * Note:
 *
 * Both of the given trees will have between 1 and 100 nodes.
 */
public class LeafSimilarTrees {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * Naive approach. Traverse both trees using DFS and compare sequence.
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        getLeafSequence(list1, root1);
        getLeafSequence(list2, root2);
        return list1.equals(list2);
    }
    private void getLeafSequence(ArrayList<Integer> list, TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }
        getLeafSequence(list, root.left);
        getLeafSequence(list, root.right);
    }

    /**
     *
     */
    public boolean leafSimilar2(TreeNode root1, TreeNode root2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        getLeafSequence2(s1, root1);
        getLeafSequence2(s2, root2);
        return s1.equals(s2);
    }
    private void getLeafSequence2(StringBuilder sb, TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            return;
        }
        getLeafSequence2(sb, root.left);
        getLeafSequence2(sb, root.right);
    }

}
