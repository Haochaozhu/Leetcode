/*
Given a sorted linked list, delete all nodes that have duplicate numbers,
leaving only distinct numbers from the original list.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3

 */
public class RemoveDupsFromSortedListII {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode prev = sentinel;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val ) cur = cur.next;
            if (prev.next == cur) prev = prev.next;
            else prev.next = cur.next;
            cur = cur.next;
        }
        return sentinel.next;
    }
}
