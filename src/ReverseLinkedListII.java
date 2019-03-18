/*
Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL

 */
public class ReverseLinkedListII {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode prev = null, cur = head;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m -= 1;
            n -= 1;
        }
        ListNode temp = null, front = prev, tail = cur;
        while (n > 0) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
            n -= 1;
        }
        if (front != null) front.next = prev;
        else head = prev;
        tail.next = cur;
        return head;
    }
}
