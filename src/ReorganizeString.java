/**
 * Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
 *
 * If possible, output any possible result.  If not possible, return the empty string.
 *
 * Example 1:
 *
 * Input: S = "aab"
 * Output: "aba"
 * Example 2:
 *
 * Input: S = "aaab"
 * Output: ""
 * Note:
 *
 * S will consist of lowercase letters and have length in range [1, 500].
 */
import java.util.*;
public class ReorganizeString {
    public String reorganizeString(String S) {
        int[] count = new int[26];
        for (char c : S.toCharArray()) count[c - 'a']++;
        PriorityQueue<Character> pq = new PriorityQueue<>((c1, c2) -> count[c2 - 'a'] - count[c1 - 'a']);
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) pq.offer((char)(i + 'a'));
        }
        StringBuilder sb = new StringBuilder();
        char prev = '#';
        while (!pq.isEmpty()) {
            char cur = pq.poll();
            count[cur - 'a']--;
            sb.append(cur);
            if (prev != '#' && count[prev - 'a'] > 0) pq.offer(prev);
            prev = cur;
        }
        return sb.length() == S.length() ? sb.toString() : "";
    }
}
