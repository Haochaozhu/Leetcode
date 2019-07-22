/**
 * We partition a row of numbers A into at most K adjacent (non-empty) groups,
 * then our score is the sum of the average of each group. What is the largest score we can achieve?
 *
 * Note that our partition must use every number in A, and that scores are not necessarily integers.
 *
 * Example:
 * Input:
 * A = [9,1,2,3,9]
 * K = 3
 * Output: 20
 * Explanation:
 * The best choice is to partition A into [9], [1, 2, 3], [9]. The answer is 9 +
 * (1 + 2 + 3) / 3 + 9 = 20.
 * We could have also partitioned A into [9, 1], [2], [3, 9], for example.
 * That partition would lead to a score of 5 + 2 + 6 = 13, which is worse.
 *
 * 9 1 2 3
 * 91 2 3
 * 9 12 3
 *
 * Note:
 *
 * 1 <= A.length <= 100.
 * 1 <= A[i] <= 10000.
 * 1 <= K <= A.length.
 * Answers within 10^-6 of the correct answer will be accepted as correct.
 */
public class LargestSumOfAverages {
    public double largestSumOfAverages(int[] A, int K) {
        int n = A.length;
        int[] preSum = new int[n];
        double[][] dp = new double[n][K + 1];
        preSum[0] = A[0];
        dp[0][1] = A[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + A[i];
            dp[i][1] = preSum[i] * 1.0 / (i + 1);
        }
        for (int k = 2; k <= K; k++) {
            for (int i = 0; i < n; i++) {
                double max = 0;
                for (int p = 0; p < i; p++) {
                    double sum = dp[p][k - 1] + (preSum[i] - preSum[p]) * 1.0/ (i - p);
                    max = Math.max(max, sum);
                }
                dp[i][k] = max;
            }
        }
        return dp[n - 1][K];
    }
}
