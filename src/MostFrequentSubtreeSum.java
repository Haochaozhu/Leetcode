import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given the root of a tree, you are asked to find the most frequent subtree sum.
 * The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node
 * (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
 *
 * Examples 1
 * Input:
 *
 *   5
 *  /  \
 * 2   -3
 * return [2, -3, 4], since all the values happen only once, return all of them in any order.
 * Examples 2
 * Input:
 *
 *   5
 *  /  \
 * 2   -5
 * return [2], since 2 happens twice, however -5 only occur once.
 * Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 */
public class MostFrequentSubtreeSum {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        traversal(map, root);
        int maxFreq = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) > maxFreq) {
                maxFreq = map.get(key);
                ans.clear();
                ans.add(key);
            } else if (map.get(key) == maxFreq) {
                ans.add(key);
            }
        }
        int[] s = new int[ans.size()];
        for (int i = 0; i < ans.size(); i += 1) s[i] = ans.get(i);
        return s;
    }

    private int traversal(Map<Integer, Integer> map, TreeNode root) {
        if (root == null) return 0;
        int leftSum = traversal(map, root.left);
        int rightSum = traversal(map, root.right);
        int subTreeSum = leftSum + rightSum + root.val;
        map.put(subTreeSum, map.getOrDefault(subTreeSum, 0) + 1);
        return subTreeSum;
    }
}
