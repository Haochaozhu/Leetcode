/**
 * Given a square array of integers A, we want the minimum sum of a falling path through A.
 *
 * A falling path starts at any element in the first row, and
 * chooses one element from each row.
 * The next row's choice must be in a column that is different from the
 * previous row's column by at most one.
 *
 *
 *
 * Example 1:
 *
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: 12
 * Explanation:
 * The possible falling paths are:
 * [1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
 * [2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
 * [3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
 * The falling path with the smallest sum is [1,4,7], so the answer is 12.
 *
 *
 *
 * Note:
 *
 * 1 <= A.length == A[0].length <= 100
 * -100 <= A[i][j] <= 100
 */
public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[m][n]; // min fall to current col
        for (int i = 0; i < n; i += 1) {
            dp[0][i] = A[0][i];
        }
        for (int i = 1; i < m; i += 1) {
            for (int j = 0; j < n; j += 1) {
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + A[i][j];
                } else if (j == n - 1) {
                    dp[i][j] =  Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + A[i][j];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i - 1][j + 1]) + A[i][j];
                }
            }
        }
        for (int i = 0; i < n; i += 1) {
            min = Math.min(min, dp[m - 1][i]);
        }
        return min;
    }
}
/**
 1 2 3
 4 5 6
 7 8 9
 **/