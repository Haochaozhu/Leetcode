/**
 * Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.
 *
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 *
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 * Example :
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 */
public class PlusOneLinkedList {
    private int carry = 1;
    public ListNode plusOne(ListNode head) {
        if (head == null) return null;
        head = go(head);
        if (carry == 1) {
            ListNode ans = new ListNode(1);
            ans.next = head;
            return ans;
        }
        return head;
    }

    private ListNode go(ListNode head) {
        if (head == null) return null;
        head.next = go(head.next);
        int sum = head.val + carry;
        carry = sum / 10;
        head.val = sum % 10;
        return head;
    }
}
