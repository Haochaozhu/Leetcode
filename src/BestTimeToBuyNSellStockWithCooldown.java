/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 *
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * Example:
 *
 * Input: [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 *
 *
 *
 **/
public class BestTimeToBuyNSellStockWithCooldown {

    /**
     * For day i, we have three options: buy, sell and cooldown.
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        buy[1] = -Math.min(prices[0], prices[1]);
        sell[0] = 0;
        sell[1] = prices[1] - prices[0] > 0 ? prices[1] - prices[0] : 0;
        for (int i = 2; i < prices.length; i += 1) {
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return sell[prices.length - 1];
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int has0_buy = -prices[0];
        int has0_doNothing = 0;
        int has1_sell = 0;
        int has1_doNothing = -prices[0];
        for (int i = 1; i < prices.length; i += 1) {
            int l1 = has0_buy;
            int l2 = has0_doNothing;
            int l3 = has1_sell;
            int l4 = has1_doNothing;
            has0_doNothing = Math.max(l2, l3);
            has0_buy = l2 - prices[i];
            has1_doNothing = Math.max(l1, l4);
            has1_sell = Math.max(l1, l4) + prices[i];
        }
        return Math.max(has1_sell, has0_doNothing);
    }
}
