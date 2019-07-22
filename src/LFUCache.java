import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 **/
public class LFUCache {
    private static class DLNode {
        int key;
        int val;
        int freq;
        DLNode pre;
        DLNode next;

        DLNode(int key, int val) {
            this.freq = 1;
            this.key = key;
            this.val = val;
        }
    }

    private static class DLList {
        DLNode head;
        DLNode tail;
        int size;

        DLList () {
            size = 0;
            head = new DLNode(0,0);
            tail = new DLNode(0,0);
            tail.pre = head;
            head.next = tail;

        }
        void addNode(DLNode cur) {
            cur.pre = head;
            cur.next = head.next;
            head.next.pre = cur;
            head.next = cur;
            size++;
        }
        void deleteNode(DLNode cur) {
            DLNode pre = cur.pre;
            DLNode next = cur.next;
            pre.next = next;
            next.pre = pre;
            size--;
        }
        void moveToHead(DLNode cur) {
            deleteNode(cur);
            addNode(cur);
        }
        DLNode pop() {
            DLNode toPop = tail.pre;
            deleteNode(toPop);
            return toPop;
        }
        private int size() {
            return this.size;
        }
    }

    int capacity;
    int min;
    Map<Integer, DLList> freqMap;
    Map<Integer, DLNode> KVMap;

    public LFUCache(int capacity) {
        min = 1;
        this.capacity = capacity;
        KVMap = new HashMap();
        freqMap = new HashMap();
    }

    public int get(int key) {
        DLNode res = KVMap.get(key);
        if (res == null) {
            return -1;
        }
        update(res);
        return res.val;
    }

    public void put(int key, int value) {
        if (KVMap.get(key) == null) {
            DLNode temp = new DLNode(key, value);
            KVMap.put(key, temp);
            DLList minLst = freqMap.getOrDefault(1, new DLList());
            minLst.addNode(temp);
            freqMap.put(1, minLst);
            if (KVMap.size() > capacity) {
                DLList tempLst = freqMap.get(min);
                KVMap.remove(tempLst.pop().key);
                freqMap.put(min, tempLst);
            }
            min = 1;
        } else {
            DLNode cur = KVMap.get(key);
            cur.val = value;
            update(cur);
        }
    }

    private void update(DLNode node) {
        DLList lst = freqMap.get(node.freq);
        lst.deleteNode(node);
        if (node.freq == min && lst.size == 0) {
            min++;
        }
        node.freq = node.freq + 1;
        DLList temp = freqMap.getOrDefault(node.freq, new DLList());
        temp.addNode(node);
        freqMap.put(node.freq, temp);
    }

}
