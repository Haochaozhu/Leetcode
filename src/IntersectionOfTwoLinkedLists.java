/*
Write a program to find the node at which the intersection of two singly linked lists begins.

 */

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}

/*
Let M equals length of list A and N equals length of List B.
M + N = N + M
 */
