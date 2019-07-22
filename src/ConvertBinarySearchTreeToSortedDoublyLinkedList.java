import java.util.Stack;

/**
 * Convert a BST to a sorted circular doubly-linked list in-place. Think of the left and right pointers as synonymous
 * to the previous and next pointers in a doubly-linked list.
 *
 * Let's take the following BST as an example, it may help you understand the problem better:
 *
 * We want to transform this BST into a circular doubly linked list. Each node in a doubly
 * linked list has a predecessor and successor. For a circular doubly linked list, the predecessor of
 * the first element is the last element, and the successor of the last element is the first element.
 *
 * The figure below shows the circular doubly linked list for the BST above.
 * The "head" symbol means the node it points to is the smallest element of the linked list.
 *
 * Specifically, we want to do the transformation in place. After the transformation,
 * the left pointer of the tree node should point to its predecessor,
 *  and the right pointer should point to its successor. We should return the pointer to
 *  the first element of the linked list.
 *
 * The figure below shows the transformed BST. The solid line indicates the successor relationship,
 * while the dashed line means the predecessor relationship.
 */
public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Node head = null;
        Node cur = root;
        Node prev = null;
        Stack<Node> st = new Stack<>();
        while (cur != null || !st.isEmpty()) {
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            if (head == null) head = cur;
            cur.left = prev;
            if (prev != null) {
                prev.right = cur;
            }
            prev = cur;
            cur = cur.right;
        }
        head.left = prev;
        prev.right = head;
        return head;
    }
}
