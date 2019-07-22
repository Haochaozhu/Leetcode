/**
 * Given many words, words[i] has weight i.
 *
 * Design a class WordFilter that supports one function, WordFilter.f(String prefix, String suffix).
 * It will return the word with given prefix and suffix with maximum weight. If no word exists, return -1.
 *
 * Examples:
 *
 * Input:
 * WordFilter(["apple"])
 * WordFilter.f("a", "e") // returns 0
 * WordFilter.f("b", "") // returns -1
 *
 *
 * Note:
 *
 * words has length in range [1, 15000].
 * For each test case, up to words.length queries WordFilter.f may be made.
 * words[i] has length in range [1, 10].
 * prefix, suffix have lengths in range [0, 10].
 * words[i] and prefix, suffix queries consist of lowercase letters only.
 */
public class PrefixAndSuffixSearch {
    private class Node {
        int weight;
        Node[] next;
        Node() {
            next = new Node[27];
        }
    }
    Node root;
    public PrefixAndSuffixSearch(String[] words) {
        root = new Node();
        for (int i = 0; i < words.length; i++) {
            String cur = words[i] + "{";
            for (int j = 0; j < cur.length(); j++) {
                Node temp = root;
                for (int k = j; k < cur.length() * 2 - 1; k++) {
                    int idx = cur.charAt(k % cur.length()) - 'a';
                    if (temp.next[idx] == null) temp.next[idx] = new Node();
                    temp = temp.next[idx];
                    temp.weight = i;
                }
            }
        }
    }

    public int f(String prefix, String suffix) {
        Node temp = root;
        for (char c : (suffix + "{" + prefix).toCharArray()) {
            if (temp.next[c - 'a'] == null) return -1;
            temp = temp.next[c - 'a'];
        }
        return temp.weight;
    }

}
