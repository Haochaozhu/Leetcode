import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.*;
/**
 * 1104. Path In Zigzag Labelled Binary Tree
 * User Accepted: 197
 * User Tried: 213
 * Total Accepted: 197
 * Total Submissions: 236
 * Difficulty: Easy
 * In an infinite binary tree where every node has two children, the nodes are labelled in row order.
 *
 * In the odd numbered rows (ie., the first, third, fifth,...), the labelling is left to right, while in the even numbered rows (second, fourth, sixth,...), the labelling is right to left.
 *
 *
 *
 * Given the label of a node in this tree, return the labels in the path from the root of the tree to the node with that label.
 *
 *
 *
 * Example 1:
 *
 * Input: label = 14
 * Output: [1,3,4,14]
 * Example 2:
 *
 * Input: label = 26
 * Output: [1,2,6,10,26]
 *
 *
 * Constraints:
 *
 * 1 <= label <= 10^6
 */
public class PathInZigzagLabelledBinaryTree {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> ans = new ArrayList<>();
        int temp = label;
        int level = 0;
        while (temp > 0) {
            temp -= Math.pow(2, level);
            level++;
        }
        level--;
        System.out.println(level);
        ans.add(label);
        while (label >= 1) {
            label /= 2;
            ans.add(swap(label, level));
            level--;
        }

        return ans;
    }

    private static int swap(int a, int level) {
            double nums = Math.pow(2, level);
            double j = 2 * nums - 1;
            for (double i = nums; i <= 2 * nums - 1; i++) {
                if (i == a) return (int)j;
                j--;
            }
            return 0;
        }

    public static void main(String[] args) {
        System.out.println(swap(2, 1));
    }

}
