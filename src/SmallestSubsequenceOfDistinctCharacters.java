import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Return the lexicographically smallest subsequence of text that contains all the distinct characters of text exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: "cdadabcc"
 * Output: "adbc"
 * Example 2:
 *
 * Input: "abcd"
 * Output: "abcd"
 * Example 3:
 *
 * Input: "ecbacba"
 * Output: "eacb"
 * Example 4:
 *
 * Input: "leetcode"
 * Output: "letcod"
 *
 *
 * Note:
 *
 * 1 <= text.length <= 1000
 * text consists of lowercase English letters.
 *
 */
public class SmallestSubsequenceOfDistinctCharacters {
    public String smallestSubsequence(String text) {
        int[] count = new int[26];
        Stack<Character> st = new Stack();
        Set<Character> set = new HashSet();
        for (char c : text.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : text.toCharArray()) {
            if (set.contains(c)) {
                count[c - 'a']--;
                continue;
            }
            while (!st.isEmpty() && c < st.peek() && count[st.peek() - 'a'] > 1) {
                count[st.peek() - 'a']--;
                set.remove(st.peek());
                st.pop();
            }
            st.push(c);
            set.add(c);
        }
        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }
}
