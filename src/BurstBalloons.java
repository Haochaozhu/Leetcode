/**
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 *
 * Find the maximum coins you can collect by bursting the balloons wisely.
 *
 * Note:
 *
 * You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * Example:
 *
 * Input: [3,1,5,8]
 * Output: 167
 * Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *              coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 */
public class BurstBalloons {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[][] dp = new int[n][n];
        return getMax(nums, dp, 0, n - 1);
    }

    private int getMax(int[] nums, int[][] dp, int start, int end) {
        if (start > end) return 0;
        if (dp[start][end] != 0) {
            return dp[start][end];
        }
        int max = 0;
        for (int i = start; i <= end; i++) {
            int val = nums[i] * getVal(nums, start - 1) * getVal(nums, end + 1);
            val += getMax(nums, dp, start, i - 1);
            val += getMax(nums, dp, i + 1, end);
            max = Math.max(max, val);
        }
        dp[start][end] = max;
        return max;
    }
    private int getVal(int[] nums, int idx) {
        if (idx < 0 || idx >= nums.length) {
            return 1;
        }
        return nums[idx];
    }
}
