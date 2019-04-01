import edu.princeton.cs.algs4.In;

import java.util.Arrays;

/**
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: 6
 *
 *
 * Example 2:
 *
 * Input: [1,2,3,4]
 * Output: 24
 *
 * Case 1 : all positive:
 * nums[N - 1] * num[N -2] * nums[N -3]
 *
 * case 2: all negative:
 * -6 -5 -4 -3 -2 -1
 *
 * also nums[N - 1] * num[N -2] * nums[N -3]
 *
 * case 3:
 *-4 -3 -2 -1 0 1 2
 *-4 1 2 3 4 5 6
 * Note:
 *
 * The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
 * Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
 */
public class MaximumProductOfThreeNumbers {
    /**
     * Using sorting.
     * Time complexity: O(NlogN)
     */
    public int maximumProduct(int[] nums) {
        int N = nums.length;
        Arrays.sort(nums);
        return Math.max((nums[N - 1] * nums[N -2] * nums[N -3]), nums[0] * nums[1] * nums[N - 1]);
    }

    /**
     * Based on the key findings that the maximum product should be the maximum of either:
     * nums[N - 1] * nums[N -2] * nums[N -3]
     * or :
     * nums[0] * nums[1] * nums[N - 1]
     */
    public int maximumProduct1(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n >= max3) {
                max3 = n;
            } else if (n >= max2) {
                max2 = n;
            } else if (n >= max1) {
                max1 = n;
            }

            if (n <= min1) {
                min1 = n;
            } else if (n <= min2){
                min2 = n;
            }
        }
        return Math.max((min1 * min2 * max3), (max1 * max2 * max3));
    }

}
