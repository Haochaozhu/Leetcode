import java.util.HashSet;
import java.util.Set;

/**
 * Given a non-empty string check if it can be constructed by taking a
 * substring of it and appending multiple copies of the substring together.
 * You may assume the given string consists of lowercase English letters only
 * and its length will not exceed 10000.
 * Example 1:
 *
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 * Example 2:
 *
 * Input: "aba"
 * Output: False
 * Example 3:
 * aaaa bbbb cccc
 * Input: "abc abc abc abc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.isEmpty()) return false;
        int N = s.length();
        if (N % 2 == 0) {
            for (int i = 0; i < N / 2; i++) {

            }
            return false;
        } else {
            for (int i = 1; i < N; i++) {
                if (s.charAt(i) != s.charAt(i - 1)) return false;
            }
            return true;
        }
    }
}
