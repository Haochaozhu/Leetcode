/**
 * Design your implementation of the linked list.
 * You can choose to use the singly linked list or the doubly linked list.
 * A node in a singly linked list should have two attributes: val and
 * next. val is the value of the current node, and next is a pointer/reference to the next node.
 * If you want to use the doubly linked list,
 * you will need one more attribute prev to indicate the previous node in the linked list.
 * Assume all nodes in the linked list are 0-indexed.
 *
 * Implement these functions in your linked list class:
 *
 * get(index) : Get the value of the index-th node in the linked list.
 * If the index is invalid, return -1.
 * addAtHead(val) : Add a node of value val before the first element of the linked list.
 * After the insertion, the new node will be the first node of the linked list.
 * addAtTail(val) : Append a node of value val to the last element of the linked list.
 * addAtIndex(index, val) : Add a node of value val before the index-th node in the linked list.
 * If index equals to the length of linked list,
 * the node will be appended to the end of linked list.
 * If index is greater than the length, the node will not be inserted.
 * deleteAtIndex(index) : Delete the index-th node in the linked list, if the index is valid.
 * Example:
 *
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
 * linkedList.get(1);            // returns 2
 * linkedList.deleteAtIndex(1);  // now the linked list is 1->3
 * linkedList.get(1);            // returns 3
 * Note:
 *
 * All values will be in the range of [1, 1000].
 * The number of operations will be in the range of [1, 1000].
 * Please do not use the built-in LinkedList library.
 */
public class DesignLinkedList {

    private static class MyNode {
        int val;
        MyNode next;
        MyNode(int val) {
            this.val = val;
        }
    }
    /** Initialize your data structure here. */

    MyNode sentinel;
    int size;
    public DesignLinkedList() {
        sentinel = new MyNode(0);
        size = 0;
    }
    // 0 1 2 3 4
    /** Get the value of the index-th node in the linked list.
     * If the index is invalid, return -1. */
    // S -> 1->3
    public int get(int index) {
        if (size == 0) return -1;
        int idx = 0;
        MyNode cur = sentinel;
        while (cur.next != null && idx < index) {
            idx += 1;
            cur = cur.next;
        }
        return cur.next == null ? -1 : cur.next.val;
    }

    /** Add a node of value val before the first element of the linked list.
     * After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        MyNode temp = sentinel.next;
        sentinel.next = new MyNode(val);
        sentinel.next.next = temp;
        size += 1;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        MyNode cur = sentinel;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new MyNode(val);
        size += 1;
    }

    /** Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list,
     * the node will be appended to the end of linked list. I
     * f index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size) return;
        int idx = 0;
        MyNode cur = sentinel;
        while (cur.next != null && idx < index) {
            cur = cur.next;
            idx += 1;
        }
        MyNode temp = cur.next;
        cur.next = new MyNode(val);
        cur.next.next = temp;
        size += 1;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    // S -> 1 -> 2 -> 3 1 -> 3
    public void deleteAtIndex(int index) {
        if (index >= size) return;
        int idx = 0;
        MyNode cur = sentinel;
        while (cur.next != null && idx < index) {
            cur = cur.next;
            idx += 1;
        }
        if (cur.next != null) cur.next = cur.next.next;
        size -= 1;
    }

    public void myToString() {
        MyNode cur = sentinel.next;
        while (cur != null) {
            System.out.print(cur.val + "   ");
            cur = cur.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        DesignLinkedList ls = new DesignLinkedList();
        ls.addAtHead(1);
        ls.addAtTail(3);
        ls.addAtIndex(4, 2);
        ls.myToString();
        System.out.println(ls.get(1));

    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

