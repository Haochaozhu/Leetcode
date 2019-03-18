import java.util.Arrays;

/*
Given an array nums of n integers and an integer target,
find three integers in nums such that the sum is closest to target.
Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).


-4 -1 1 2
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int minDiff = Integer.MAX_VALUE;
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i += 1) {
            int p = i + 1; int q = nums.length - 1;
            while (p < q) {
                int sum = nums[i] + nums[p] + nums[q];
                if (sum == target) return target;
                else if (sum < target) p += 1;
                else q -= 1;
                if (Math.abs(sum - target) < minDiff) {
                    minDiff = Math.abs(sum - target);
                    res = sum;
                }
            }
        }
        return res;
    }
}
