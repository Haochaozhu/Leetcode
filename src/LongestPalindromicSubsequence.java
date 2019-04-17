import java.util.Arrays;

/**
 * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 * Input:
 *
 * "bbbab"
 * Output:
 * 4
 * One possible longest palindromic subsequence is "bbbb".
 * Example 2:
 * Input:
 *
 * "cbbd"
 * Output:
 * 2
 * One possible longest palindromic subsequence is "bb".
 */
public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseqBF(String s) {
        if (s == null || s.isEmpty()) return 0;
        int n = s.length();
        Integer[][] memo = new Integer[n][n];
        return BfHelper(s, 0, s.length() - 1, memo);
    }

    private int BfHelper(String s, int l, int r, Integer[][] memo) {
        if (memo[l][r] != null) return memo[l][r];
        if (l == r) return 1;
        if (l > r) return 0;
        if (s.charAt(l) == s.charAt(r)) {
            memo[l][r] = 2 + BfHelper(s, l + 1, r - 1, memo);
        }
        else {
            memo[l][r] = Math.max(BfHelper(s, l + 1, r, memo), BfHelper(s, l, r - 1, memo));
        }
        return memo[l][r];
    }
}
// "bbbab"