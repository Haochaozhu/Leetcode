/**
 * Given a non-empty string s and an integer k, rearrange the string such that the same characters are at least distance k from each other.
 *
 * All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".
 *
 * Example 1:
 *
 * Input: s = "aabbcc", k = 3
 * Output: "abcabc"
 * Explanation: The same letters are at least distance 3 from each other.
 * Example 2:
 *
 * Input: s = "aaabc", k = 3
 * Output: ""
 * Explanation: It is not possible to rearrange the string.
 * Example 3:
 *
 * Input: s = "aaadbbcc", k = 2
 * Output: "abacabcd"
 * Explanation: The same letters are at least distance 2 from each other.
 */

import java.util.*;
public class RearrangeStringKDistanceApart {
    public String rearrangeString(String s, int k) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) count[c - 'a']++;
        PriorityQueue<Character> pq = new PriorityQueue<>((c1, c2) -> count[c2 - 'a'] - count[c1 - 'a']);
        for (int i = 0; i < 26; i++) if (count[i] > 0) pq.offer((char)('a' + i));
        StringBuilder ans = new StringBuilder();
        Queue<Character> cache = new LinkedList<>();
        while (!pq.isEmpty()) {
            char cur = pq.poll();
            ans.append(cur);
            count[cur - 'a']--;
            cache.offer(cur);
            if (cache.size() < k) continue;
            char prev = cache.poll();
            if (count[prev - 'a'] > 0) pq.offer(prev);
        }
        return ans.length() == s.length() ? ans.toString() : "";
    }
}
