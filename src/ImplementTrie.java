/**
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Example:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * Note:
 *
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 */
public class ImplementTrie {
    private Node root;
    private static int R = 26;
    private class Node {
        private boolean exist;
        private Node[] next = new Node[26];
    }

    public ImplementTrie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        root = put(root, word, 0);
    }

    private Node put(Node x, String word, int d) {
        if (x == null) x = new Node();
        if (d == word.length()) {
            x.exist = true;
            return x;
        }
        char c = word.charAt(d);
        x.next[c - 'a'] = put(x.next[c - 'a'], word, d + 1);
        return x;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node x = search(root, word, 0);
        if (x == null) return false;
        return x.exist;
    }

    private Node search(Node x, String word, int d) {
        if (x == null) return null;
        if (d == word.length()) return x;
        char c = word.charAt(d);
        return search(x.next[c - 'a'], word, d + 1);
    }
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node x = search(root, prefix, 0);
        if (x == null) return false;
        if (x.exist) return true;
        return startsWith(x);
    }

    private boolean startsWith(Node x) {
        for (int i = 0; i < R; i += 1) {
            if (x.next[i] != null) {
                if (x.next[i].exist) {
                    return true;
                }
                else startsWith(x.next[i]);
            }
        }
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

