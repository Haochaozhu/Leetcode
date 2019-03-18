import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 *
 * The order of output does not matter.
 *
 * Example 1:
 *
 * Input:
 * s: "c b a e b  a  b  a c d" p: "abc"
 *     1 0 0  -1 -1 -2 -2 0
 *
 * Output:
 * [0, 6]
 *
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 *
 * Input:
 * s: "abab" p: "ab"
 *
 * Output:
 * [0, 1, 2]
 *
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */


/**
 *
 * aab
 * a b
 * 2 1
 * aaaaaaaaaa
 */
public class FindAllAnagramsInAString {
    /**
     * Brute force approach. Terrible performance.
     * Assument length of s is M, length of p is N.
     * Time complexity: O(M * N).
     */
    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int n = p.length();
        for (int i = 0; i <= s.length() - n; i += 1) {
            String cur = s.substring(i, i + n);
            if (isAnagram(cur, p)) ans.add(i);
        }
        return ans;
    }

    /**
     * Helper function Time complexity: O(2N) -> O(N)
     */
    private boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        for (char c : t.toCharArray()) {
            count[c]--;
            if (count[c] < 0) return false;
        }
        return true;
    }

    /**
     * Sliding window algorithm.
     */
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (p.length() > s.length()) return ans;
        int L = 0, R = 0, counter = p.length();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        while (R < s.length()) {
            char c = s.charAt(R);
            if (map.containsKey(c)) {

            }
        }
        return ans;
    }



}
