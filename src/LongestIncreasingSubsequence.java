/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * Example:
 *
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Note:
 *
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 */
public class LongestIncreasingSubsequence {
    /**
     * DP approach.
     * dp[i] records the LIS ad position i (0 <= i <= nums.length - 1).
     * Time complexity: O(n²).
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxAns = 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i += 1) {
            int maxLength = 0;
            for (int j = 0; j < i; j += 1) {
                if (nums[i] > nums[j]) {
                    maxLength = Math.max(maxLength, dp[j]);
                }
            }
            dp[i] = maxLength + 1;
            maxAns = Math.max(maxAns, dp[i]);
        }
        return maxAns;
    }

    /**
     * Approach using binary search.
     * tails[i] stores the smallest ending number for sequence length i + 1;
     * Say tails[] has i items. Iterates through the input array,
     * if dp[0] < nums[cur] <= dp[i], then replace, dp[i++] = nums[cur].
     * if nums[cur] > tails[i], append to tails[]. tails[i + 1] = nums[cur], i += 1;
     * Example, for input [10,9,2,5,3,7,101,18]
     * dp[]:
     * 10
     * 9
     * 2
     * 2, 5
     * 2, 3
     * 2, 3, 7
     * 2, 3, 7, 101
     * 2, 3, 7, 18
     */
    public int lengthOfLIS2(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int n : nums) {
            int i = 0, j = size;
            while (i != j) {
                int mid = i + (j - i) / 2;
                if (tails[mid] < n) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
            tails[i] = n;
            if (i == size) size += 1;
        }
        return size;
    }
}
