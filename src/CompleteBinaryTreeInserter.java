import java.util.LinkedList;
import java.util.Queue;

/**
 * A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.
 *
 * Write a data structure CBTInserter that is initialized with a complete binary tree and supports the following operations:
 *
 * CBTInserter(TreeNode root) initializes the data structure on a given tree with head node root;
 * CBTInserter.insert(int v) will insert a TreeNode into the tree with value node.val = v so that the tree remains complete, and returns the value of the parent of the inserted TreeNode;
 * CBTInserter.get_root() will return the head node of the tree.
 *
 *
 * Example 1:
 *
 * Input: inputs = ["CBTInserter","insert","get_root"], inputs = [[[1]],[2],[]]
 * Output: [null,1,[1,2]]
 * Example 2:
 *
 * Input: inputs = ["CBTInserter","insert","insert","get_root"], inputs = [[[1,2,3,4,5,6]],[7],[8],[]]
 * Output: [null,3,4,[1,2,3,4,5,6,7,8]]
 *
 *
 * Note:
 *
 * The initial given tree is complete and contains between 1 and 1000 nodes.
 * CBTInserter.insert is called at most 10000 times per test case.
 * Every value of a given or inserted node is between 0 and 5000.
 */
public class CompleteBinaryTreeInserter {
    TreeNode root;
    TreeNode cur;
    Queue<TreeNode> que;
    public CompleteBinaryTreeInserter(TreeNode root) {
        this.root = root;
        que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = que.poll();
                if (temp.left != null) {
                    que.offer(temp.left);
                }
                if (temp.right != null) {
                    que.offer(temp.right);
                }
                if (temp.left == null || temp.right == null) {
                    cur = temp;
                    return;
                }
            }
        }
    }

    public int insert(int v) {
        int res = cur.val;
        // insert at left
        if (cur.left == null) {
            cur.left = new TreeNode(v);
            que.offer(cur.left);
        } else { // insert at right, change cur node
            cur.right = new TreeNode(v);
            que.offer(cur.right);
            cur = que.poll();
        }
        return res;
    }

    public TreeNode get_root() {
        return root;
    }

}
