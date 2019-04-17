/**
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -.
 * For each integer, you should choose one from + and - as its new symbol.
 *
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 *
 * Example 1:
 * Input: nums is [1, 1, 1, 1, 1], S is 3.
 * Output: 5
 * Explanation:
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 * Note:
 * The length of the given array is positive and will not exceed 20.
 * The sum of elements in the given array will not exceed 1000.
 * Your output answer is guaranteed to be fitted in a 32-bit integer.
 */
public class TargetSum {

    /**
     * Analysis: Assume Sum(nums), positive subset P and negative subset N.
     * P + N = S
     * P - N = sum
     * 2P = S + sum
     * sum(P) = (S + sum) / 2
     * Find the number of subsets that sum to (S + sum) / 2
     * This problem can be transferred to 416. Paritial Equal Subset Sum.
     *
     */
    public static int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum < S || (S + sum) % 2 != 0) return 0;
        return subSetSumDp2(nums, (S + sum) / 2);
    }


    private static void printer(int[][] dp) {
        for (int[] ha : dp) {
            for (int ok : ha) {
                System.out.print(ok + "  ");
            }
            System.out.println();
        }
    }

    private int subsetSumDP(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n];
        return dp[s];
    }

    private static int subSetSumDp2(int[] nums, int s) {
        int[][] dp = new int[nums.length + 1][s + 1];
        for (int i = 0; i <= nums.length; i += 1) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= nums.length; i += 1) {
            for (int j = 0; j <= s; j += 1) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) dp[i][j] += dp[i - 1][j - nums[i - 1]];
            }
        }
        return dp[nums.length][s];
    }

    public static void main(String[] args) {
        System.out.println(subSetSumDp2(new int[]{1,5,11,5}, 11));
    }
}
// [1, 5, 11, 5]

/**       0     1
    0     1     0
    1     1     1
    0     1     2
 **/
