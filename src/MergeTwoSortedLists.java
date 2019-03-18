/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
     * Naive iterative approach.
     * Redundant code after one of the pointer is null.
     * Why? Because the two lists are sorted. When one of the pointer is null, simply link to
     * the head of another pointer.
     * Time complexity: O(N) where N is the total number of nodes in two lists.
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(0);
        ListNode cur = sentinel;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }


        if (l1 == null) {
            while (l2 != null) {
                cur.next = l2;      //Redundant to loop through l2. Just link to l2.
                cur = cur.next;
                l2 = l2.next;
            }
        }
        if (l2 == null) {
            while (l1 != null) {
                cur.next = l1;      //Redundant.
                cur = cur.next;
                l1 = l1.next;
            }
        }
        return sentinel.next;
    }

    /**
     * Refactored code for iterative approach.
     * Time complexity: same as above.
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(0);
        ListNode dummy = sentinel;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                dummy.next = l2;
                l2 = l2.next;
            } else {
                dummy.next = l1;
                l1 = l1.next;
            }
            dummy = dummy.next;
        }
        if (l1 == null) {
            dummy.next = l2;
        } else {
            dummy.next = l1;
        }
        return sentinel.next;
    }

    /**
     * Recursive approach. The content of the original lists will be modified.
     */
    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val > l2.val) {
            l2.next = mergeTwoLists3(l1, l2.next);
            return l2;
        } else {
            l1.next = mergeTwoLists3(l1.next, l2);
            return l1;
        }
    }

}
