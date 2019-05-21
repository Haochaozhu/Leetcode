import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given an array nums and a target value k, find the maximum length of a
 * subarray that sums to k. If there isn't one, return 0 instead.
 Note:
 The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.

 Example 1:

 Input: nums = [1, -1, 5, -2, 3], k = 3
 Output: 4
 Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
 Example 2:

 Input: nums = [-2, -1, 2, 1], k = 1
 Output: 2
 Explanation: The subarray [-1, 2] sums to 1 and is the longest.
 Follow Up:
 Can you do it in O(n) time?
 */
public class MaximumSizeSubarraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int curSum = 0;
        int n = nums.length;
        int max = 0;
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            curSum += nums[i];
            System.out.println(curSum);
            if (!map.containsKey(curSum)) {
                map.put(curSum, i);
            }
            if (map.containsKey(curSum - k)) {
                max = Math.max(i - map.get(curSum - k), max);
            }
            System.out.println(max);
        }
        return max;
    }
}

