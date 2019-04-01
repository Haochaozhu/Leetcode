/**
 * Given a positive integer n, find the least number of
 * perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * 1 4 9 16 25 36 64 ...
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 *
 * dp[0] = 0
 * dp[1] = 1
 * dp[2] = 2
 * dp[3] = 3
 * dp[4] =
 */
public class PerfectSquare {
    /**
     * Dp approach.
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            int sqrt = (int)Math.sqrt(i);
            if (sqrt * sqrt == i) {
                dp[i] = 1;
                continue;
            }
            for (int j = 1; j <= sqrt; j++) {
                int dif = i - j * j;
                dp[i] = Math.min(dp[i], (dp[dif] + 1));
            }
        }
        return dp[n];
    }

}
