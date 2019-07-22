public class FlattenAMultilevelDoublyLinkedList {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    // return tail node of a sequence
    private Node dfs(Node node) {
        if (node == null) return null;
        Node cur = node;
        while (cur != null && (cur.next != null || cur.child != null)) {
            if (cur.child == null) {
                cur = cur.next;
            } else {
                Node temp = cur.next;
                cur.next = cur.child;
                cur.child.prev = cur;
                Node childTail = dfs(cur.child);
                if (temp != null) {
                    childTail.next = temp;
                    temp.prev = childTail;
                }
                cur.child = null;
                cur = temp;
            }
        }
        return cur;
    }

}
