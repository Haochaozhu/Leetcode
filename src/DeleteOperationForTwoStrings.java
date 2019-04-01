/**
 * Given two words word1 and word2, find the minimum number
 * of steps required to make word1 and word2 the same,
 * where in each step you can delete one character in either string.
 *
 * Example 1:
 * Input: "sea", "eat"
 * Output: 2
 * Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 * Note:
 * The length of given words won't exceed 500.
 * Characters in given words can only be lower-case letters.
 *
 *
 * find the minimum number of steps == find the largest common substring.
 */
public class DeleteOperationForTwoStrings {

    /**
     * Basic recursion for finding LCS.
     */
    public static int LCS(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0) return 0;
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return 1 + LCS(s1, s2, m - 1, n - 1);
        } else {
            return Math.max(LCS(s1, s2, m - 1, n), LCS(s1, s2, m, n - 1));
        }
    }

    /**
     * Finding LCS with memorization. Top-down DP.
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] memo = new int[m + 1][n + 1];
        int len = LCS(word1, word2, m, n, memo);
        return m + n - 2 * len;
    }

    public static int LCS(String s1, String s2, int m, int n, int[][] memo) {
        if (m == 0 || n == 0) return 0;
        if (memo[m][n] != 0) return memo[m][n];
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            memo[m][n] = 1 + LCS(s1, s2, m - 1, n - 1, memo);
        } else {
            memo[m][n] = Math.max(LCS(s1, s2, m - 1, n, memo), LCS(s1, s2, m, n - 1, memo));
        }
        return memo[m][n];
    }

    /**
     * Bottom Up dp
     */
    public int minDistance2(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i += 1) {
            for (int j = 0; j <= n; j += 1) {
                if (i == 0 || j == 0) continue;
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return m + n - 2 * dp[m][n];
    }
    public static void main(String[] args) {

    }
}
