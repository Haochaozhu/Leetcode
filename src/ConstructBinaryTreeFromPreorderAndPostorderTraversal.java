/**
 * Return any binary tree that matches the given preorder and postorder traversals.
 *
 * Values in the traversals pre and post are distinct positive integers.
 *
 *
 *
 * Example 1:
 *
 * Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
 * Output: [1,2,3,4,5,6,7]
 *
 *
 * Note:
 *
 * 1 <= pre.length == post.length <= 30
 * pre[] and post[] are both permutations of 1, 2, ..., pre.length.
 * It is guaranteed an answer exists. If there exists multiple answers, you can return any of them.
 */
import java.util.*;
public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int n = pre.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(post[i], i);
        }
        return dfs(pre, 0, n - 1, post, 0, n - 1, map);
    }
    private TreeNode dfs(int[] pre, int preL, int preR, int[] post, int postL, int postR, Map<Integer, Integer> map) {
        if (preL > preR || postL > postR) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preL]);
        if (preL + 1 <= preR) {
            int leftNodes = map.get(pre[preL + 1]) - postL;
            root.left = dfs(pre, preL + 1, preL + 1 + leftNodes, post, postL, postL + leftNodes, map);
            root.right = dfs(pre, preL + 1 + leftNodes + 1, preR, post, postL + leftNodes + 1, postR - 1, map);
        }
        return root;
    }

    public static void main(String[] args) {
        long temp = -2147483647 - 2147483647;
        System.out.println();
    }
}
