import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
Given an array nums of n integers and an integer target,
are there elements a, b, c, and d in nums such that a + b + c + d = target?
Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]

-2, -1, 0, 0, 1, 2
i   j   p        q


 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i += 1) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j += 1) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int twoSum = target - nums[i] - nums[j];
                int minSum = nums[j + 1] + nums[j + 2];
                int maxSum = nums[nums.length - 1] + nums[nums.length - 2];
                if (minSum > twoSum || maxSum < twoSum) continue;
                int p = j + 1, q = nums.length - 1;
                while (p < q) {
                    int temp = nums[p] + nums[q];
                    if (temp == twoSum) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[p], nums[q]));
                        p += 1;
                        q -= 1;
                        while (p < q && nums[p] == nums[p - 1]) p += 1;
                        while (p < q && nums[q] == nums[q + 1]) q -= 1;
                    } else if (temp < twoSum) {
                        p += 1;
                    } else {
                        q -= 1;
                    }
                }
            }
        }
        return ans;
    }
}
