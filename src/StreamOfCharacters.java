import java.util.*;

/**
 * Implement the StreamChecker class as follows:
 *
 * StreamChecker(words): Constructor, init the data structure with the given words.
 * query(letter): returns true if and only if for some k >= 1, the last k characters queried (in order from oldest to newest, including this letter just queried) spell one of the words in the given list.
 *
 *
 * Example:
 *
 * StreamChecker streamChecker = new StreamChecker(["cd","f","kl"]); // init the dictionary.
 * streamChecker.query('a');          // return false
 * streamChecker.query('b');          // return false
 * streamChecker.query('c');          // return false
 * streamChecker.query('d');          // return true, because 'cd' is in the wordlist
 * streamChecker.query('e');          // return false
 * streamChecker.query('f');          // return true, because 'f' is in the wordlist
 * streamChecker.query('g');          // return false
 * streamChecker.query('h');          // return false
 * streamChecker.query('i');          // return false
 * streamChecker.query('j');          // return false
 * streamChecker.query('k');          // return false
 * streamChecker.query('l');          // return true, because 'kl' is in the wordlist
 *
 *
 * Note:
 *
 * 1 <= words.length <= 2000
 * 1 <= words[i].length <= 2000
 * Words will only consist of lowercase English letters.
 * Queries will only consist of lowercase English letters.
 * The number of queries is at most 40000.
 */
public class StreamOfCharacters {
    TrieNode root;
    List<Character> lst;
    int maxL;
    public StreamOfCharacters(String[] words) {
        root = new TrieNode();
        lst = new ArrayList<>();
        root = build(words);
    }
    private TrieNode build(String[] words) {
        TrieNode p;
        for (String word : words) {
            maxL = Math.max(maxL, word.length());
            p = root;
            for (char c : new StringBuilder(word).reverse().toString().toCharArray()) {
                if (p.next[c- 'a'] == null) {
                    p.next[c - 'a'] = new TrieNode();
                }
                p = p.next[c - 'a'];
            }
            p.exist = true;
        }
        return root;
    }

    public boolean query(char letter) {
        lst.add(letter);
        TrieNode p = root;
        if (lst.size() > maxL) lst.remove(0);
        for (int i = lst.size() - 1; i >= 0; i--) {
            char cur = lst.get(i);
            if (p.next[cur - 'a'] == null) return false;
            p = p.next[cur - 'a'];
            if (p.exist) return true;
        }
        return p.exist;
    }

    private class TrieNode {
        boolean exist;
        TrieNode[] next;
        TrieNode() {
            next = new TrieNode[26];
        }
    }

}
