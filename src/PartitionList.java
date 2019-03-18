import java.util.List;

/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5

 */
public class PartitionList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode partition(ListNode head, int x) {
        ListNode before = new ListNode(0);
        ListNode bfDummy = before;
        ListNode after = new ListNode(0);
        ListNode afDummy = after;
        while (head != null) {
            if (head.val < x) {
                bfDummy.next = head;
                bfDummy = bfDummy.next;
            } else {
                afDummy.next = head;
                afDummy = afDummy.next;
            }
            head = head.next;
        }
        afDummy.next = null;
        bfDummy.next = after.next;
        return before.next;
    }
}
