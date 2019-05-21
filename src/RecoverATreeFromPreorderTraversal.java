import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * We run a preorder depth first search on the root of a binary tree.
 *
 * At each node in this traversal, we output D dashes (where D is the depth of this node),
 * then we output the value of this node.  (If the depth of a node is D, the depth of its immediate child is D+1.  The depth of the root node is 0.)
 *
 * If a node has only one child, that child is guaranteed to be the left child.
 *
 * Given the output S of this traversal, recover the tree and return its root.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: "1-2--3--4-5--6--7"
 * Output: [1,2,5,3,4,6,7]
 * Example 2:
 *
 *
 *
 * Input: "1-2--3---4-5--6---7"
 * Output: [1,2,5,3,null,6,null,4,null,7]
 *
 *
 * Example 3:
 *
 *
 *
 * Input: "1-401--349---90--88"
 * Output: [1,401,null,349,88,90]
 *
 *
 * Note:
 *
 * The number of nodes in the original tree is between 1 and 1000.
 * Each node will have a value between 1 and 10^9.
 */
public class RecoverATreeFromPreorderTraversal {
    public TreeNode recoverFromPreorder(String S) {
        if (S == null || S.isEmpty()) return null;
        ArrayList<Integer> lst = convert(S);
        Stack<TreeNode> st = new Stack<>();
        TreeNode root = new TreeNode(lst.get(0));
        TreeNode cur = root;
        st.push(root);
        for (int i = 1; i < lst.size(); i += 1) {
            int dashes = lst.get(i);
            i += 1;
            while (st.size() > dashes) {
                st.pop();
                cur = st.peek();
            }
            TreeNode child = new TreeNode(lst.get(i));
            st.push(child);
            if (cur.left == null) cur.left = child;
            else cur.right = child;
            cur = child;
        }
        return root;
    }
    private ArrayList<Integer> convert(String s) {
        ArrayList<Integer> sb = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '-') {
                int dashes = 0;
                while (i < s.length() && s.charAt(i) == '-') {
                    dashes += 1;
                    i += 1;
                }
                sb.add(dashes);
            } else {
                int temp = 0;
                while (i < s.length() && s.charAt(i) != '-') {
                    temp = temp * 10 + (s.charAt(i) - '0');
                    i += 1;
                }
                sb.add(temp);
            }
        }
        return sb;
    }

    public static void main(String[] args) {
    }
}
