import java.util.HashSet;
import java.util.Set;

/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3

 */
public class RemoveDuplicatesFromSortedList {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = head;

        while (dummy != null) {
            while (dummy.next != null && dummy.next.val == dummy.val) {
                dummy.next = dummy.next.next;
            }
            dummy = dummy.next;
        }
        return head;
    }

}
