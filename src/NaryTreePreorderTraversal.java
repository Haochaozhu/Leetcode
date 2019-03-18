import edu.princeton.cs.algs4.Stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an n-ary tree, return the preorder traversal of its nodes' values.
 *
 * For example, given a 3-ary tree:
 * Return its preorder traversal as: [1,3,5,6,2,4].
 * Note:
 *
 * Recursive solution is trivial, could you do it iteratively?
 */
public class NaryTreePreorderTraversal {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     * Recursive approach. Trivial.
     */
    public List<Integer> preorder1(Node root) {
        List<Integer> ans = new ArrayList<>();
        preorder(ans, root);
        return ans;
    }

    private void preorder(List<Integer> ans, Node root) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        for (Node child : root.children) {
            preorder(ans, child);
        }
    }

    /**
     * Iterative solution. Non-trivial.
     */
    public List<Integer> preorder2(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        LinkedList<Node> stash = new LinkedList<>();
        stash.add(root);
        while (!stash.isEmpty()) {
            Node cur = stash.removeLast();
            ans.add(cur.val);
            int position = 0;
            for (Node child : cur.children) {
                stash.add(stash.size() - position, child);
                position += 1;
            }
        }
        return ans;
    }

    /**
     * Another iterative solution.
     */
    public List<Integer> preorder3(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Stack<Node> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            Node cur = st.pop();
            ans.add(cur.val);
            for (int i = cur.children.size() - 1; i >= 0; i -= 1) {
                st.push(cur.children.get(i));
            }
        }
        return ans;
    }

}
