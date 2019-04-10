import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a complete binary tree, count the number of nodes.
 *
 * Note:
 *
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last,
 * is completely filled, and all nodes in the last level are as far left as possible.
 * It can have between 1 and 2h nodes inclusive at the last level h.
 *
 * Example:
 *
 * Input:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * Output: 6
 * 1 + 2 + 4 +
 */
public class CountCompleteTreeNodes {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * Brute force solution. Use level order traversal to count the number of nodes. Go through each node.
     * Time complexity: O(n)
     */
    public int countNodes(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i += 1) {
                TreeNode cur = queue.remove();
                count += 1;
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
        }
        return count;
    }

    /**
     * This solution uses the same idea as Binary search. Count node numbers above the last level.
     * For nodes in the last level, first find a midNode, that is: root -> left->right->right...->the last node.
     * if this node is not null, it means the last node of the whole tree is on the right half, else on the left
     * tree.
     *
     * Note use bit manipulation for calculation.
     * e.g. 1 << 1 = Math.pow(2, 1)
     *      1 << 2 = Math.pow(2, 2)
     */
    public int countNodes1(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return 1;
        int height = 0;
        int sum = 0;
        TreeNode cur = root;
        while (cur.left != null) {
            sum += (1 << height);
            height += 1;
            cur = cur.left;
        }
        return sum + countLastLevel(root, height);
    }

    private int countLastLevel(TreeNode root, int height) {
        if (height == 1) {
            if (root.right != null) return 2;
            else if (root.left != null) return 1;
            else return 0;
        }
        TreeNode midNode = root.left;
        int midHeight = 1;
        while (midHeight < height) {
            midHeight += 1;
            midNode = midNode.right;
        }
        if (midNode == null) return countLastLevel(root.left, height - 1);
        else return (1 << height - 1) + countLastLevel(root.right, height - 1);
    }

    public static void main(String[] args) {
        System.out.println(Math.pow(2, 3));
        System.out.println(1 << 3);
    }

}
