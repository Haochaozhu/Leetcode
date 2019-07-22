/**
 * Given a string S, count the number of distinct, non-empty subsequences of S .
 *
 * Since the result may be large, return the answer modulo 10^9 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: "abc"
 * Output: 7
 * Explanation: The 7 distinct subsequences are "a", "b", "c", "ab", "ac", "bc", and "abc".
 * Example 2:
 *
 * Input: "aba"
 * Output: 6
 * Explanation: The 6 distinct subsequences are "a", "b", "ab", "ba", "aa" and "aba".
 * Example 3:
 *
 * Input: "aaa"
 * Output: 3
 * Explanation: The 3 distinct subsequences are "a", "aa" and "aaa".
 *
 *
 *
 *
 * Note:
 *
 * S contains only lowercase letters.
 * 1 <= S.length <= 2000
 */
public class DistinctSubsequencesII {
    public int distinctSubseqII(String S) {
        int mod = 1_000_000_007;
        long[] end = new long[26];
        long ret = 0;
        long add = 0;
        for (char c : S.toCharArray()) {
            add = (ret + 1 + mod - end[c - 'a']) % mod;
            ret = (ret + add) % mod;
            end[c - 'a'] = (end[c - 'a'] + add) % mod;
        }
        return (int)ret;
    }
}
