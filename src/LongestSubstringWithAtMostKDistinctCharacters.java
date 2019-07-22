import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring T that
 * contains at most k distinct characters.
 *
 * Example 1:
 *
 * Input: s = "eceba", k = 2
 * Output: 3
 * Explanation: T is "ece" which its length is 3.
 * Example 2:
 *
 * Input: s = "aa", k = 1
 * Output: 2
 * Explanation: T is "aa" which its length is 2.
 */
public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        int distinct = 0;
        int l = 0;
        int max = 0;
        for (int r = 0; r < s.length(); r++) {
            if (count[s.charAt(r)] == 0) {
                distinct++;
            }
            count[s.charAt(r)]++;
            while (l <= r && distinct > k) {
                count[s.charAt(l)]--;
                if(count[s.charAt(l)] == 0) distinct--;
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
