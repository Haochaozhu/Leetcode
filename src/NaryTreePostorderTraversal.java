/**
Given an n-ary tree, return the postorder traversal of its nodes' values.

For example, given a 3-ary tree:

Return its postorder traversal as: [5,6,3,2,4,1].
 **/
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NaryTreePostorderTraversal {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> postorder(Node root) {
        Stack<Node> st = new Stack<>();
        LinkedList<Integer> ans = new LinkedList<>();
        if (root == null) return ans;
        Node cur = root;
        st.push(cur);
        while (!st.isEmpty()) {
            cur = st.pop();
            ans.addFirst(cur.val);
            for (Node children : cur.children) {
                if (children != null) st.push(children);
            }
        }
        return ans;
    }

}
