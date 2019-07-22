/**
 * Implement a MapSum class with insert, and sum methods.
 *
 * For the method insert, you'll be given a pair of (string, integer). The string represents the key and the integer represents the value. If the key already existed, then the original key-value pair will be overridden to the new one.
 *
 * For the method sum, you'll be given a string representing the prefix, and you need to return the sum of all the pairs' value whose key starts with the prefix.
 *
 * Example 1:
 * Input: insert("apple", 3), Output: Null
 * Input: sum("ap"), Output: 3
 * Input: insert("app", 2), Output: Null
 * Input: sum("ap"), Output: 5
 */
public class MapSumPairs {
    private class Node {
        boolean exist;
        int val;
        Node[] next;
        Node() {
            next = new Node[26];
        }
    }
    private Node root;
    /** Initialize your data structure here. */
    public MapSumPairs() {
        root = new Node();
    }

    public void insert(String key, int val) {
        root = put(key, val, 0, root);
    }
    private Node put(String key, int val, int d, Node cur) {
        if (cur == null) cur = new Node();
        if (d == key.length()) {
            cur.val = val;
            cur.exist = true;
            return cur;
        }
        cur.next[key.charAt(d) - 'a'] = put(key, val, d + 1, cur.next[key.charAt(d) - 'a']);
        return cur;
    }

    public int sum(String prefix) {
        Node start = search(prefix, 0, root);
        if (start == null) return 0;
        int sum = start.exist ? start.val : 0;
        return sum + add(start);
    }
    private int add(Node start) {
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (start.next[i] != null) {
                if (start.next[i].exist) sum += start.next[i].val + add(start.next[i]);
                else sum += add(start.next[i]);
            }
        }
        return sum;
    }
    private Node search(String prefix, int d, Node cur) {
        if (cur == null) return null;
        if (prefix.length() == d) return cur;
        return search(prefix, d + 1, cur.next[prefix.charAt(d) - 'a']);
    }

}
