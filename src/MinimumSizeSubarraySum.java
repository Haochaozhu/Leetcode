/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * Example:
 *
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int start = 0, minL = Integer.MAX_VALUE, curSum = 0;
        for (int end = 0; end < nums.length; end += 1) {
            curSum += nums[end];
            if (curSum >= s) {
                while (curSum >= s && start < nums.length) {
                    curSum -= nums[start];
                    start += 1;
                }
                minL = Math.min(minL, (end - start + 2));
            }
        }
        return minL > nums.length ? 0 : minL;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i += 1) {
            System.out.println(i);
        }
    }
}
