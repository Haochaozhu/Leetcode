import java.util.*;

class DesignSearchAutocompleteSystem {

    private class Node {
        boolean exist;
        String s;
        Node[] next;
        Node () {
            next = new Node[26];
        }
    }
    Node root;
    Node cur;
    StringBuilder sb;
    Map<String, Integer> map;
    public DesignSearchAutocompleteSystem(String[] sentences, int[] times) {
        sb = new StringBuilder();
        root = new Node();
        map = new HashMap<>();
        cur = root;
        for (int i = 0; i < sentences.length; i++) {
            String word = sentences[i];
            map.put(word, map.getOrDefault(word, 0) + times[i]);
            Node temp = root;
            for (char c : word.toCharArray()) {
                if (temp.next[convertToIndex(c)] == null) temp.next[convertToIndex(c)] = new Node();
                temp = temp.next[convertToIndex(c)];
            }
            temp.exist = true;
            temp.s = word;
        }
    }

    public List<String> input(char c) {
        if (c == '#') {
            cur.exist = true;
            cur.s = sb.toString();
            cur = root;
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            sb = new StringBuilder();
            return new ArrayList<>();
        }
        if (cur.next[convertToIndex(c)] == null) {
            cur.next[convertToIndex(c)] = new Node();
            cur = cur.next[convertToIndex(c)];
            sb.append(convertToIndex(c));
            return new ArrayList<>();
        }
        cur = cur.next[convertToIndex(c)];
        sb.append(c);
        PriorityQueue<String> pq = new PriorityQueue<>((s1, s2) -> map.get(s1) == map.get(s2) ? s1.compareTo(s2) : map.get(s2) - map.get(s1));
        if (cur.exist) pq.offer(cur.s);
        fetch(cur, pq);
        List<String> res = new ArrayList<>();
        while (!pq.isEmpty() && res.size() <= 3) res.add(pq.poll());

        return res;
    }
    private void fetch(Node node, PriorityQueue<String> pq) {
        for (int i = 0; i < 26; i++) {
            if (node.next[i] != null) {
                if (node.next[i].exist) pq.add(node.next[i].s);
                fetch(node.next[i], pq);
            }
        }
    }
    private int convertToIndex(char c) {
        return c - 'a' >= 0 && c - 'a' < 26 ? c - 'a' : 26;
    }
}
