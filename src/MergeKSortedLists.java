import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
     * Naive approach: Iterate through each node in each list, storing their value in a priority queue.
     * Then, extends a new list from the pq, each time create a new node with the value popped from the pq.
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ListNode sentinel = new ListNode(0);
        ListNode cur = sentinel;
        for (ListNode l : lists) {
            ListNode dummy = l;
            while (dummy != null) {
                pq.offer(dummy.val);
                dummy = dummy.next;
            }
        }
        while (!pq.isEmpty()) {
            cur.next = new ListNode(pq.poll());
            cur = cur.next;
        }
        return sentinel.next;
    }

    /**
     * Improved pq solution. Use pq to store node instead of value. override compare so that node with
     * smaller value sits on the top of the heap.
     * Initially store heads of each list in the pq.
     * Extends the new list with node popped from the pq, in the same time store the next node of the popped
     * node to pq.
     * PQ will always have K lists. Each insertion and removal will take O(lgK).
     * Assume there are N elements, time complexity: O(NlgK)
     * Space Complexity: O(k). The pq stores up to K lists.
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists==null|| lists.length == 0) return null;

        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;

        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);

        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;

            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }

    /**
     * Merge list one by one.
     */
    public ListNode mergeKLists3(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode ans = lists[0];
        int i = 1;
        while (i < lists.length) {
            ans = mergeTwoLists(ans, lists[i]);
            i += 1;
        }
        return ans;
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val > l2.val) {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        } else {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
    }

}
