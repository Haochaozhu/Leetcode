import java.util.Arrays;

/**
 * Given an array consisting of n integers,
 * find the contiguous subarray whose length is greater than or equal to k
 * that has the maximum average value. And you need to output the maximum average value.
 *
 * Example 1:
 * Input: [1,12,-5,-6,50,3], k = 4
 * -6, -5, 1, 3, 12, 50
 * Output: 12.75
 * Explanation:
 * when length is 5, maximum average value is 10.8,
 * when length is 6, maximum average value is 9.16667.
 * Thus return 12.75.
 * Note:
 * 1 <= k <= n <= 10,000.
 * Elements of the given array will be in range [-10,000, 10,000].
 * The answer with the calculation error less than 10-5 will be accepted.
 */
public class MaximumAverageSubarrayII {
    public double findMaxAverage(int[] nums, int k) {
        double l = -10000, r = 10000, mid;
        boolean flag;
        while (l + 1e-5 <= r) {
            mid = (l + r) / 2;
            flag = ok(nums, mid, k);
            if (flag) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return l;
    }
    private boolean ok(int[] nums, double max, int k) {
        int n = nums.length;
        double sum = 0, prev = 0, min = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i] - max;
        }
        if (sum >= 0) return true;
        for (int i = k; i < n; i++) {
            sum += nums[i] - max;
            prev += nums[i - k] - max;
            min = Math.min(min, prev);
            if (sum - min >= 0) return true;
        }
        return false;
    }
}
