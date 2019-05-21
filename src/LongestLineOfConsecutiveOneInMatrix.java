/**
 * Given a 01 matrix M, find the longest line of consecutive one in the matrix.
 * The line could be horizontal, vertical, diagonal or anti-diagonal.
 * Example:
 * Input:
 * [[0,1,1,0],
 *  [0,1,1,0],
 *  [0,0,0,1]]
 * Output: 3
 * Hint: The number of elements in the given matrix will not exceed 10,000.
 */
public class LongestLineOfConsecutiveOneInMatrix {
    public int longestLine(int[][] M) {
        if (M == null || M.length == 0) return 0;
        int m = M.length;
        int n = M[0].length;
        int[][][] dp = new int[m + 1][n + 2][4];
        int res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (M[i - 1][j - 1] == 1) {
                    dp[i][j][0] = dp[i][j][1] = dp[i][j][2] = dp[i][j][3] = 1;
                    dp[i][j][0] += dp[i][j - 1][0]; // horizontal
                    dp[i][j][1] += dp[i - 1][j][1]; // vertical
                    dp[i][j][2] += dp[i - 1][j - 1][2]; // diagonal
                    dp[i][j][3] += dp[i - 1][j + 1][3]; // anti-diagonal
                    int curMax = Math.max(Math.max(dp[i][j][0], dp[i][j][1]), dp[i][j][2]);
                    curMax = Math.max(curMax, dp[i][j][3]);
                    res = Math.max(res, curMax);
                }
            }
        }
        return res;
    }
}
/**
 1 1 1 1
 0 1 1 0
 0 0 0 1
 **/