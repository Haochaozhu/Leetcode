import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 */

public class LRUCache {
    private static class DLNode {
        int key;
        int val;
        DLNode pre;
        DLNode next;

        DLNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private static class DLNodeList {
        DLNode head;
        DLNode tail;

        DLNodeList () {
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
        }
         void deleteNode(DLNode cur) {
            DLNode pre = cur.pre;
            DLNode next = cur.next;
            pre.next = next;
            next.pre = pre;
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
    }

    DLNodeList lst;
    int capacity;
    Map<Integer, DLNode> map;

    public LRUCache(int capacity) {
        lst = new DLNodeList();
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        DLNode res = map.get(key);
        if (res == null) return -1;
        lst.moveToHead(res);
        return res.val;
    }

    public void put(int key, int value) {
        DLNode cur = map.get(key);
        if (cur == null) {
            cur = new DLNode(key, value);
            map.put(key, cur);
            lst.addNode(cur);
            if (map.size() > capacity) {
                map.remove(lst.pop().key);
            }
        } else {
            cur.val = value;
            lst.moveToHead(cur);
        }
    }
}
