import edu.princeton.cs.algs4.StdOut;

public class AddTwoNumbers {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode solution(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(0);
        ListNode p = l1, q = l2, cur = sentinel;
        int carry = 0;

        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        if (carry == 1) cur.next = new ListNode(1);
        sentinel = sentinel.next;
        return sentinel;
    }

    public static void main(String[] args) {
        StdOut.println(9 % 10);
    }
}
