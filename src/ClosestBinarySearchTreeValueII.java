/**
 * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
 *
 * Note:
 *
 * Given target value is a floating point.
 * You may assume k is always valid, that is: k ≤ total nodes.
 * You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
 * Example:
 *
 * Input: root = [4,2,5,1,3], target = 3.714286, and k = 2
 *
 *     4
 *    / \
 *   2   5
 *  / \
 * 1   3
 *
 * Output: [4,3]
 * Follow up:
 * Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
 */
import java.util.*;
public class ClosestBinarySearchTreeValueII {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Pair> lst = new ArrayList<>();
        dfs(root, target, lst);
        Collections.sort(lst, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Double.compare(o1.key, o2.key);
            }
        });
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(lst.get(i).val);
        }
        return ans;
    }
    private void dfs(TreeNode root, double target, List<Pair> lst) {
        if (root == null) {
            return;
        }
        double diff = Math.abs(root.val - target);
        lst.add(new Pair(diff, root.val));
        dfs(root.left, target, lst);
        dfs(root.right, target, lst);
    }

    private class Pair {
        double key;
        int val;
        Pair(double key, int val) {
            this.key = key;
            this.val = val;
        }
    }

}
