import java.util.Stack;

/**
 *You are given two non-empty linked lists representing two non-negative integers.
 * The most significant digit comes first and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 *
 * Example:
 *
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 */
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        ListNode d1 = l1, d2 = l2;
        while (d1 != null) {
            st1.push(d1.val);
            d1 = d1.next;
        }
        while (d2 != null) {
            st2.push(d2.val);
            d2 = d2.next;
        }
        ListNode newList = null;
        int sum = 0;
        while (!st1.isEmpty() || !st2.isEmpty()) {
            if (!st1.isEmpty()) sum += st1.pop();
            if (!st2.isEmpty()) sum += st2.pop();
            ListNode node = new ListNode(sum % 10);
            sum /= 10;
            node.next = newList;
            newList = node;
        }
        return newList;
    }
}
