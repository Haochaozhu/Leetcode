public class PopulatingNextRightPointersInEachNodeII {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        Node dummyHead = new Node();
        Node pre = dummyHead;
        Node dummy = root;
        while (dummy != null) {
            if (dummy.left != null) {
                pre.next = dummy.left;
                pre = pre.next;
            }
            if (dummy.right != null) {
                pre.next = dummy.right;
                pre = pre.next;
            }
            dummy = dummy.next;
            if (dummy == null) {
                pre = dummyHead;
                dummy = dummyHead.next;
                dummyHead.next = null;
            }
        }
        return root;
    }
}
