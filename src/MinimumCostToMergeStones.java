/**
 * There are N piles of stones arranged in a row.  The i-th pile has stones[i] stones.
 *
 * A move consists of merging exactly K consecutive piles into one pile, and the cost of this move is equal to the total number of stones in these K piles.
 *
 * Find the minimum cost to merge all piles of stones into one pile.  If it is impossible, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: stones = [3,2,4,1], K = 2
 * Output: 20
 * Explanation:
 * We start with [3, 2, 4, 1].
 * We merge [3, 2] for a cost of 5, and we are left with [5, 4, 1].
 * We merge [4, 1] for a cost of 5, and we are left with [5, 5].
 * We merge [5, 5] for a cost of 10, and we are left with [10].
 * The total cost was 20, and this is the minimum possible.
 * Example 2:
 *
 * Input: stones = [3,2,4,1], K = 3
 * Output: -1
 * Explanation: After any merge operation, there are 2 piles left, and we can't merge anymore.  So the task is impossible.
 * Example 3:
 *
 * Input: stones = [3,5,1,2,6], K = 3
 * Output: 25
 * Explanation:
 * We start with [3, 5, 1, 2, 6].
 * We merge [5, 1, 2] for a cost of 8, and we are left with [3, 8, 6].
 * We merge [3, 8, 6] for a cost of 17, and we are left with [17].
 * The total cost was 25, and this is the minimum possible.
 *
 *
 * Note:
 *
 * 1 <= stones.length <= 30
 * 2 <= K <= 30
 * 1 <= stones[i] <= 100
 */
public class MinimumCostToMergeStones {
    public int mergeStones(int[] stones, int K) {
        int n = stones.length;
        if ((n - 1) % (K - 1) != 0) {
            return -1;
        }
        int[][][] dp = new int[n + 1][n + 1][K + 1];
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = stones[i - 1] + preSum[i - 1];
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= K; k++) {
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            dp[i][i][1] = 0;
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i + len - 1 <= n; i++) {
                int j = i + len - 1;
                for (int k = 2; k <= K; k++) {
                    if ((i - j + 1) % (k - 1) != 0) continue;
                    for (int t = i; t < j; t++) {
                        if ((t - i + 1) % (k - 1) != 0) continue;
                        dp[i][j][k] = Math.min(dp[i][j][k], dp[i][t][k - 1] + dp[t + 1][j][1]);
                    }
                }
                if ((i - j + 1) % (K - 1) != 0) continue;
                dp[i][j][1] = dp[i][j][K] + preSum[j] - preSum[i - 1];
            }
        }
        return dp[1][n][1];
    }
}
