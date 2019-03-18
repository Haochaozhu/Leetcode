/*
Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL

 */
public class RotateList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        if (k == 0) return head;
        int listLength = 1;
        ListNode tail = head;
        while (tail.next != null) {
            listLength += 1;
            tail = tail.next;
        }
        tail.next = head;
        k %= listLength;
        int newTail = listLength - k - 1;
        ListNode dummy = head;
        while (newTail > 0) {
            dummy = dummy.next;
            newTail -= 1;
        }
        head = dummy.next;
        dummy.next = null;
        return head;
    }
}
