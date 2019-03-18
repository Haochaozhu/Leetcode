import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given a binary search tree (BST) with duplicates, find all the mode(s)
 * (the most frequently occurred element) in the given BST.
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * For example:
 * Given BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 *
 *
 * return [2].
 *
 * Note: If a tree has more than one mode, you can return them in any order.
 *
 * Follow up: Could you do that without using any extra space?
 * (Assume that the implicit stack space incurred due to recursion does not count).
 */
public class FindModeInBST {
    int maxFrequency;
    HashMap<Integer, Integer> map;
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int[] findMode(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        map = new HashMap<>();
        if (root == null) return new int[0];
        traversal(root);
        for (int key : map.keySet()) {
            if (map.get(key) == maxFrequency) ans.add(key);
        }
        int[] ans_array = new int[ans.size()];
        for (int i = 0; i < ans.size(); i += 1) {
            ans_array[i] = ans.get(i);
        }
        return ans_array;
    }

    private void traversal(TreeNode node) {
        if (node == null) return;
        traversal(node.left);
        map.put(node.val, map.getOrDefault(node.val, 0) + 1);
        maxFrequency = Math.max(maxFrequency, map.get(node.val));
        traversal(node.right);
    }

}
