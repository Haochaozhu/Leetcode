
/**
 * Find the length of the longest substring T of a given string
 * (consists of lowercase letters only) such that every character in T appears no less than k times.
 *
 * Example 1:
 *
 * Input:
 * s = "aaabb", k = 3
 *
 * Output:
 * 3
 *
 * The longest substring is "aaa", as 'a' is repeated 3 times.
 * Example 2:
 *
 * Input:
 * s = "ababbc", k = 2
 *
 * Output:
 * 5
 *
 * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 */
public class LongestSubstringWithAtLeastKRepeatingChars {
    int maxLength = 0;
    public int longestSubstring(String s, int k) {
        helper(s, k, 0, s.length() - 1);
        return maxLength;
    }

    private void helper(String s, int k, int lo, int hi) {
        if (lo > hi) return;
        int[] table = new int[26];
        for (char c : s.substring(lo, hi + 1).toCharArray()) {
            table[c - 'a'] += 1;
        }
        for (int end = lo; end <= hi; end += 1) {
            char c = s.charAt(end);
            if (table[c] < k) {
                helper(s, k, lo, end - 1);
                helper(s, k, end + 1, hi);
                return;
            }
        }
        maxLength = Math.max(maxLength, hi - lo + 1);
    }


}

/**
 * bbaaac k = 3
 * aabcbba k = 2
 */
