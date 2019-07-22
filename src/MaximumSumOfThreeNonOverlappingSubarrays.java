/**
 * In a given array nums of positive integers, find three non-overlapping subarrays with maximum sum.
 *
 * Each subarray will be of size k, and we want to maximize the sum of all 3*k entries.
 *
 * Return the result as a list of indices representing the starting position of each interval (0-indexed). If there are multiple answers, return the lexicographically smallest one.
 *
 * Example:
 *
 * Input: [1,2,1,2,6,7,5,1], 2
 * Output: [0, 3, 5]
 * Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
 * We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
 *
 *
 * Note:
 *
 * nums.length will be between 1 and 20000.
 * nums[i] will be between 1 and 65535.
 * k will be between 1 and floor(nums.length / 3).
 */
public class MaximumSumOfThreeNonOverlappingSubarrays {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        int[] left = new int[n];
        int[] right = new int[n];
        int[] ans = new int[3];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int leftMax = preSum[k] - preSum[0];
        for (int i = k; i < n; i++) {
            int cur = preSum[i + 1] - preSum[i - k + 1];
            if (cur > leftMax) {
                leftMax = cur;
                left[i] = i - k + 1;
            } else {
                left[i] = left[i - 1];
            }
        }

        int rightMax = preSum[n] - preSum[n - k];
        right[n - k] = n - k;
        for (int i = n - k - 1; i >= 0; i--) {
            int cur = preSum[i + k] - preSum[i];
            if (cur >= rightMax) {
                rightMax = cur;
                right[i] = i;
            } else {
                right[i] = right[i + 1];
            }
        }
        int max = 0;
        for (int i = k; i <= n - 2 * k; i++) {
            int l = left[i - 1];
            int r = right[i + k];
            int cur = preSum[l + k] - preSum[l] + preSum[i + k] - preSum[i] + preSum[r + k] - preSum[r];
            if (cur > max) {
                max = cur;
                ans[0] = l;
                ans[1] = i;
                ans[2] = r;
            }
        }
        return ans;
    }
}
