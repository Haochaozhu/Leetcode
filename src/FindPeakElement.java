/**
 * A peak element is an element that is greater than its neighbors.
 *
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
 *
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 *
 * You may imagine that nums[-1] = nums[n] = -∞.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * Example 2:
 *
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5
 * Explanation: Your function can return either index number 1 where the peak element is 2,
 *              or index number 5 where the peak element is 6.
 * Note:
 *
 * Your solution should be in logarithmic complexity.
 */
public class FindPeakElement {
    /**
     * Naive approach, linear scan.
     * Based on the definition of a peak element,scan through the array from left to right,
     * check if nums[i] > num[i - 1] && num[i] > num[i + 1]
     * Time complexity: O(n).
     */
    public int findPeakElement1(int[] nums) {
        if (nums.length == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1;
        for (int i = 1; i < nums.length - 1; i += 1) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) return i;
        }
        return 0;
    }

    /**
     * Linear scan with optimization.
     * Since the problem only asks us to return any of the peak, it is unnecessary to check nums[i - 1].
     */
    public int findPeakElement2(int[] nums) {
        for (int i = 0; i < nums.length - 1; i += 1) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }

    /**
     * Binary search.
     *
     */

}
