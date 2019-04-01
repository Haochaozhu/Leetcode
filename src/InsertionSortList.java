/*
Sort a linked list using insertion sort.


Algorithm of Insertion Sort:

Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data,
finds the location it belongs within the sorted list, and inserts it there.
It repeats until no input elements remain.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4

Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5

 */
public class InsertionSortList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
                return head;
        }
        ListNode prev = head;
        ListNode curr = head.next;
        while (curr != null) {
            ListNode temp = curr.next;
            if (curr.val <= head.val) {
                prev.next = curr.next;
                curr.next = head;
                head = curr;
            } else if (curr.val >= prev.val) {
                prev = prev.next;
            } else {
                ListNode insertAfter = head;
                while (insertAfter.next.val < curr.val) insertAfter = insertAfter.next;
                prev.next = curr.next;
                curr.next = insertAfter.next;
                insertAfter.next = curr;
            }
            curr = temp;
        }
        return head;
    }

}
