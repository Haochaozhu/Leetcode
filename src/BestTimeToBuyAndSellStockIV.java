/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 *
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 *
 * Example 1:
 *
 * Input: [2,4,1], k = 2
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
 * Example 2:
 *
 * Input: [3,2,6,5,0,3], k = 2
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
 *              Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 */
public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;
        if (k >= n / 2) {
            int sum = 0;
            for (int i = 1; i < n; i++) {
                if (i > 0 && prices[i] > prices[i - 1]) {
                    sum += prices[i] - prices[i - 1];
                }
            }
            return sum;
        }
        int[][] hold = new int[n][k + 1];
        int[][] unhold = new int[n][k + 1];
        hold[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            hold[i][0] = Math.max(hold[i - 1][0], -prices[i]);
        }
        for (int i = 1; i <= k; i++) {
            hold[0][i] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                hold[i][j] = Math.max(hold[i - 1][j], unhold[i - 1][j] - prices[i]);
                unhold[i][j] = Math.max(unhold[i - 1][j], hold[i - 1][j - 1] + prices[i]);
            }
        }
        return unhold[n - 1][k];
    }
}
