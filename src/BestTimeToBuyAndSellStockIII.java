/**
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 *
 * Note: You may not engage in multiple transactions at the same time
 * (i.e., you must sell the stock before you buy again).
 *
 * Example 1:
 *
 * Input: [ 3, 3, 5, 0, 0, 3, 1, 4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 *              Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 * Example 2:
 *
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimeToBuyAndSellStockIII {
    public static int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        int sell1 = 0, sell2 = 0;
        for (int price : prices) {
            buy1 = Math.max(buy1, -price);                 // Keeps the lowest  prices so far for the first buy.
            sell1 = Math.max(sell1, buy1 + price);         // Keeps the maximum profit so far for the first sell.
            buy2 = Math.max(buy2, sell1 - price);
            sell2 = Math.max(sell2, buy2 + price);
            System.out.print("buy1: " + buy1);
            System.out.print("    sell1: " + sell1);
            System.out.print("    buy2: " + buy2);
            System.out.print("    sell2: " + sell2);
            System.out.println();
        }
        return sell2;
    }

    public static void main(String[] args) {
        int[] input = new int[]{3,3,5,0,0,3,1,4};
        maxProfit(input);
    }


}
