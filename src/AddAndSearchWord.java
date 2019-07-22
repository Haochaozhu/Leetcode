/**
 * Design a data structure that supports the following two operations:
 *
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 *
 * Example:
 *
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 */
public class AddAndSearchWord {
    Trie myTrie;
    /** Initialize your data structure here. */
    public AddAndSearchWord() {
        myTrie = new Trie();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        myTrie.insert(word);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (word == null || word.isEmpty()) return false;
        return myTrie.search(word);
    }

    class Trie {
        private Node root;
        private int R = 26;
        private class Node {
            boolean exist;
            Node[] next;
            Node() {
                next = new Node[26];
            }
        }
        /** Initialize your data structure here. */
        public Trie() {
            root = new Node();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            root = put(word, 0, root);
        }
        private Node put(String word, int d, Node cur) {
            if (cur == null) cur = new Node();
            if (d == word.length()) {
                cur.exist = true;
                return cur;
            }
            char c = word.charAt(d);
            cur.next[c - 'a'] = put(word, d + 1, cur.next[c - 'a']);
            return cur;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Node x = search(word, 0, root);
            if (x == null) return false;
            return x.exist;
        }
        private Node search(String word, int d, Node cur) {
            if (cur == null) return null;
            if (word.length() == d) return cur;
            char curChar = word.charAt(d);
            if (curChar == '.') {
                for (int i = 0; i < 26; i++) {
                    if (cur.next[i] != null) {
                        Node temp = search(word, d + 1, cur.next[i]);
                        if (temp == null) continue;
                        if (temp.exist) return temp;
                    }
                }
            }
            else return search(word, d + 1, cur.next[curChar - 'a']);
            return null;
        }
        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Node x = search(prefix, 0, root);
            if (x == null) return false;
            if (x.exist) return true;
            return startsWith(x);
        }
        private boolean startsWith(Node cur) {
            for (int i = 0; i < 26; i++) {
                if (cur.next[i] != null) {
                    if (cur.next[i].exist) return true;
                    return startsWith(cur.next[i]);
                }
            }
            return false;
        }
    }

}
