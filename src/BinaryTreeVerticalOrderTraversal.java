import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
 *
 * If two nodes are in the same row and column, the order should be from left to right.
 *
 * Examples 1:
 *
 * Input: [3,9,20,null,null,15,7]
 *
 *    3
 *   /\
 *  /  \
 *  9  20
 *     /\
 *    /  \
 *   15   7
 *
 * Output:
 *
 * [
 *   [9],
 *   [3,15],
 *   [20],
 *   [7]
 * ]
 * Examples 2:
 *
 * Input: [3,9,8,4,0,1,7]
 *
 *      3
 *     /\
 *    /  \
 *    9   8
 *   /\  /\
 *  /  \/  \
 *  4  01   7
 *
 * Output:
 *
 * [
 *   [4],
 *   [9],
 *   [3,0,1],
 *   [8],
 *   [7]
 * ]
 * Examples 3:
 *
 * Input: [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5)
 *
 *      3
 *     /\
 *    /  \
 *    9   8
 *   /\  /\
 *  /  \/  \
 *  4  01   7
 *     /\
 *    /  \
 *    5   2
 *
 * Output:
 *
 * [
 *   [4],
 *   [9,5],
 *   [3,0,1],
 *   [8,2],
 *   [7]
 *]
 */
public class BinaryTreeVerticalOrderTraversal {
    private class Pair {
        TreeNode node;
        int pos;
        Pair(TreeNode node, int pos) {
            this.node = node;
            this.pos = pos;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        int[] size = new int[2];
        dfs(root, 0, size);
        for (int i = 0; i < -size[0] + size[1] + 1; i++) {
            ans.add(new ArrayList<>());
        }
        int fix = -size[0];
        Queue<Pair> que = new LinkedList<>();
        que.offer(new Pair(root, 0));
        while (!que.isEmpty()) {
            int sz = que.size();
            for (int i = 0; i < sz; i++) {
                Pair cur = que.poll();
                ans.get(cur.pos + fix).add(cur.node.val);
                if (cur.node.left != null) que.offer(new Pair(cur.node.left, cur.pos - 1));
                if (cur.node.right != null) que.offer(new Pair(cur.node.right, cur.pos + 1));
            }
        }
        return ans;
    }
    private void dfs(TreeNode root, int balance, int[] size) {
        if (root == null) {
            return;
        }
        size[0] = Math.min(size[0], balance);
        size[1] = Math.max(size[1], balance);
        dfs(root.left, balance - 1, size);
        dfs(root.right, balance + 1, size);
    }
}
