import java.util.List;

/**
 * In English, we have a concept called root, which can be followed by
 * some other words to form another longer word - let's call this word successor.
 * For example, the root an, followed by other, which can form another word another.
 *
 * Now, given a dictionary consisting of many roots and a sentence.
 * You need to replace all the successor in the sentence with the root forming it.
 * If a successor has many roots can form it, replace it with the root with the shortest length.
 *
 * You need to output the sentence after the replacement.
 *
 * Example 1:
 *
 * Input: dict = ["cat", "bat", "rat"]
 * sentence = "the cattle was rattled by the battery"
 * Output: "the cat was rat by the bat"
 *
 *
 * Note:
 *
 * The input will only have lower-case letters.
 * 1 <= dict words number <= 1000
 * 1 <= sentence words number <= 1000
 * 1 <= root length <= 100
 * 1 <= sentence words length <= 1000
 */
public class ReplaceWords {
    public String replaceWords(List<String> dict, String sentence) {
        String[] words = sentence.split(" ");
        Trie tr = new Trie();
        for (String word : dict) {
            tr.insert(word);
        }
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            int i = 1;
            for (; i <= word.length(); i++) {
                String cur = word.substring(0, i);
                if (tr.search(cur)) {
                    sb.append(cur);
                    sb.append(" ");
                    break;
                }
            }
            if (i == word.length() + 1) {
                sb.append(word);
                sb.append(" ");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    private class Trie {
        private Node root;
        private int R = 26;
        private class Node {
            private boolean exist;
            private Node[] next = new Node[26];
        }


        /** Initialize your data structure here. */
        public Trie() {
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
                    else return startsWith(x.next[i]);
                }
            }
            return false;
        }
    }

}
