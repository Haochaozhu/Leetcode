import java.util.ArrayList;
import java.util.List;

/**
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 *
 *
 *
 * Example:
 *
 * Input:
 * board = [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 * words = ["oath","pea","eat","rain"]
 *
 * Output: ["eat","oath"]
 *
 *
 * Note:
 *
 * All inputs are consist of lowercase letters a-z.
 * The values of words are distinct.
 */
public class WordSearchII {
    List<String> ans = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;
        Trie myTrie = new Trie();
        for (String s : words) myTrie.insert(s);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                StringBuilder sb = new StringBuilder();
                boolean[][] visited = new boolean[m][n];
                dfs(board, sb, i, j, myTrie, m, n, visited);
            }
        }
        return ans;
    }
    private void dfs(char[][] board, StringBuilder sb, int i, int j, Trie myTrie, int m, int n, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j]) return;
        sb.append(board[i][j]);
        if (!myTrie.startsWith(sb.toString())) {
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        if (myTrie.search(sb.toString())) {
            if (!ans.contains(sb.toString())) ans.add(sb.toString());
        }
        visited[i][j] = true;
        dfs(board, sb, i + 1, j, myTrie, m, n, visited);
        dfs(board, sb, i - 1, j, myTrie, m, n, visited);
        dfs(board, sb, i, j + 1, myTrie, m, n, visited);
        dfs(board, sb, i, j - 1, myTrie, m, n, visited);
        visited[i][j] = false;
        sb.deleteCharAt(sb.length() - 1);
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
            return search(word, d + 1, cur.next[word.charAt(d) - 'a']);
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

    public static void main(String[] args) {
        String s = "0010";
        s = s.replaceAll("^0+", "");
        System.out.println(s);
    }
}
