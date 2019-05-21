import java.util.Arrays;

/**
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] == j ) dp[i][j] = 1;
                else {
                    dp[i][j] = dp[i - 1][j];
                    if (j > coins[i - 1]) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - coins[i - 1]] + 1);
                    }
                }
            }
        }
        return dp[coins.length][amount] >= Integer.MAX_VALUE / 2 ? -1 : dp[coins.length][amount];
    }
}
/**
 1
 2
 5
 **/