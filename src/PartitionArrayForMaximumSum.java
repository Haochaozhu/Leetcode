/**
 * Given an integer array A, you partition the array into (contiguous) subarrays
 * of length at most K.  After partitioning, each subarray has their values changed
 * to become the maximum value of that subarray.
 *
 * Return the largest sum of the given array after partitioning.
 *
 *
 *
 * Example 1:
 *
 * Input: A = [1,15,7,9,2,5,10], K = 3
 * Output: 84
 * Explanation: A becomes [15,15,15,9,10,10,10]
 * Note:
 *
 * 1 <= K <= A.length <= 500
 * 0 <= A[i] <= 10^6
 */
public class PartitionArrayForMaximumSum {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int n = A.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int max = A[i];
            for (int j = 0; j < K && i - j >= 0; j++) {
                max = Math.max(max, A[i - j]);
                dp[i] = Math.max(dp[i], (i - j - 1 >= 0 ? dp[i - j - 1] : 0) + max * (j + 1));
            }
        }
        return dp[n - 1];
    }
}
