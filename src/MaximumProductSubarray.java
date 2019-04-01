/**
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 * 2, 3, -2, 4
 * 2, 6, -2, 4
 *
 *
 *
 * [-2,   3,   -4,     9,     -8]
 *
 * [-2,   3,   24,   24 * 9 ,  24 * 36]
 *
 * [-2,  -6,  -12,   -108,    -72]
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int ans = nums[0], prevMax = nums[0], preMin = nums[0];
        for (int i = 1; i < nums.length; i += 1) {
            int temp = prevMax;
            prevMax = Math.max(Math.max(nums[i] * prevMax, nums[i] * preMin), nums[i]);
            preMin = Math.min((Math.min(nums[i] * temp, nums[i] * preMin)), nums[i]);
            ans = Math.max(ans, prevMax);
        }
        return ans;
    }
}
