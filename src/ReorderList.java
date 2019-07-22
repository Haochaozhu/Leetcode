import java.util.List;
import java.util.Stack;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example 1:
 *
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 *
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 *
 * 1, 2, 3, 4, 5, 6
 * 1, 2, 3, 6, 5, 4
 *
 * 1, 6, 2, 6, 3, 4
 *
 * *
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode p = head;
        ListNode q = head;
        ListNode prev = new ListNode(0);
        prev.next = head;
        while (p != null && p.next != null) {
            p = p.next.next;
            q = q.next;
            prev = prev.next;
        }
        prev.next = reverse(q, null);
        ListNode l1 = head, l2 = prev.next;
        while (l1 != null && l2 != null && l1.next != l2) {
            p = l1.next;
            q = l2.next;
            l1.next = l2;
            l2.next = p;
            l1 = p;
            l2 = q;
            prev.next = l2;
        }
    }
    private ListNode reverse(ListNode head, ListNode prev) {
        if (head == null) return prev;
        ListNode temp = head.next;
        head.next = prev;
        return reverse(temp, head);
    }
}
