/**
 * Given a string, your task is to count how many palindromic substrings in this string.
 *
 * The substrings with different start indexes or end indexes
 * are counted as different substrings even they consist of same characters.
 *
 * Example 1:
 *
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 *
 *
 * Example 2:
 *
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 *
 *
 * Note:
 *
 * The input string length won't exceed 1000.
 */
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        if (s == null || s.isEmpty()) return 0;
        int ans = 0;
        int N = s.length();
        boolean[][] dp = new boolean[N][N]; // dp[i][j] -> substring(i, j) is palindromic
        for (int i = 0; i < N; i += 1) {
            dp[i][i] = true;
            ans += 1;
        }
        for (int k = 2; k <= N; k += 1) {
            for (int i = 0; i < N - k + 1; i += 1) {
                int j = i + k - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    ans += 1;
                }
            }
        }
        return ans;
    }
}
