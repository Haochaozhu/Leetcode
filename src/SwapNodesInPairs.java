
/*
Given a linked list, swap every two adjacent nodes and return its head.

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
Note:

Your algorithm should use only constant extra space.
You may not modify the values in the list's nodes, only nodes itself may be changed.

1 -> 2 -> 3 -> 4
2 -> 1 -> 4 -> 3
 */
public class SwapNodesInPairs {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode cur = head;
        ListNode next = head.next;
        ListNode prev = sentinel;

        while (next != null) {
            ListNode temp = next.next;
            next.next = cur;
            cur.next = temp;
            prev.next = next;
            prev = cur;
            if (temp == null) break;
            cur = temp;
            next = temp.next;
        }
        return sentinel.next;
    }
}
