/**
 * Given a string s , find the length of the longest substring t  that
 * \contains at most 2 distinct characters.
 *
 * Example 1:
 *
 * Input: "eceba"
 * Output: 3
 * Explanation: t is "ece" which its length is 3.
 * Example 2:
 *
 * Input: "ccaabbb"
 * Output: 5
 * Explanation: t is "aabbb" which its length is 5.
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] count = new int[256];
        int distinct = 0;
        int l = 0;
        int max = 0;
        for (int r = 0; r < s.length(); r++) {
            if (count[s.charAt(r)] == 0) {
                distinct++;
            }
            count[s.charAt(r)]++;
            while (l <= r && distinct > 2) {
                count[s.charAt(l)]--;
                if(count[s.charAt(l)] == 0) distinct--;
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
